package AmazonInterview.SystemDesign.ParkingStystem;

import java.util.*;
import java.util.concurrent.TimeUnit;

// Enums
enum VehicleType {
    HANDICAP,
    CAR,
    MOTORCYCLE,
    LARGE_VEHICLE
}

enum TicketStatus {
    ACTIVE,
    PAID,
    EXPIRED
}

// Singleton Pattern for ParkingLot
class ParkingLot {
    private static volatile ParkingLot instance = null;
    private List<ParkingFloor> floors;
    private List<Entrance> entrances;
    private List<Exit> exits;
    private static final int PARKING_CAPACITY = 10000;
    private int availableSpots;

    private ParkingLot() {
        floors = new ArrayList<>();
        entrances = new ArrayList<>();
        exits = new ArrayList<>();
        availableSpots = PARKING_CAPACITY;
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    instance = new ParkingLot();
                }
            }
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public List<Exit> getExits() {
        return exits;
    }

    public List<Entrance> getEntrances() {
        return entrances;
    }

    public void addEntrance(Entrance entrance) {
        entrances.add(entrance);
    }

    public void addExit(Exit exit) {
        exits.add(exit);
    }

    public synchronized ParkingSpot getParkingSpot(VehicleType type) {
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.getAvailableSpot(type);
            if (spot != null) {
                availableSpots--;
                return spot;
            }
        }
        return null;
    }

    public synchronized void freeParkingSpot(ParkingSpot spot) {
        spot.removeVehicle();
        availableSpots++;
        notifyAll(); // Notify waiting threads that a spot is available
    }
}

// ParkingFloor
class ParkingFloor {
    private String floorId;
    private Map<VehicleType, List<ParkingSpot>> parkingSpots;
    private DisplayBoard displayBoard;

    public ParkingFloor(String floorId) {
        this.floorId = floorId;
        this.parkingSpots = new HashMap<>();
        this.displayBoard = new DisplayBoard();

        // Initialize with empty lists for each vehicle type
        for (VehicleType type : VehicleType.values()) {
            parkingSpots.put(type, new ArrayList<>());
        }
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.get(spot.getType()).add(spot);
        updateDisplayBoard();
    }

    public ParkingSpot getAvailableSpot(VehicleType type) {
        List<ParkingSpot> spots = parkingSpots.get(type);
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable()) {
                return spot;
            }
        }
        return null;
    }

    public void updateDisplayBoard() {
        for (VehicleType type : VehicleType.values()) {
            int availableSpots = countAvailableSpots(type);
            displayBoard.updateAvailableSpots(type, availableSpots);
        }
    }

    private int countAvailableSpots(VehicleType type) {
        int count = 0;
        for (ParkingSpot spot : parkingSpots.get(type)) {
            if (spot.isAvailable()) {
                count++;
            }
        }
        return count;
    }
}

// ParkingSpot
class ParkingSpot {
    private String spotId;
    private VehicleType type;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(String spotId, VehicleType type) {
        this.spotId = spotId;
        this.type = type;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isOccupied = true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isOccupied = false;
    }

    public VehicleType getType() {
        return type;
    }

    public String getSpotId() {
        return spotId;
    }
}

// Vehicle - Factory Pattern
class VehicleFactory {
    public static Vehicle createVehicle(String licensePlate, VehicleType type) {
        return new Vehicle(licensePlate, type);
    }
}

class Vehicle {
    private String licensePlate;
    private VehicleType type;

    public Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public VehicleType getType() {
        return type;
    }
}

// Ticket - Factory Pattern
class TicketFactory {
    private static int ticketCounter = 0;

    public static Ticket createTicket(Vehicle vehicle, ParkingSpot spot) {
        return new Ticket("TICKET-" + (++ticketCounter), vehicle, spot);
    }
}

class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Date entryTime;
    private Date exitTime;
    private double amount;
    private TicketStatus status;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = spot;
        this.entryTime = new Date();
        this.status = TicketStatus.ACTIVE;
    }

    public void markAsExited() {
        this.exitTime = new Date();
    }

    public void markAsPaid() {
        this.status = TicketStatus.PAID;
    }

    public long getParkingDurationInHours() {
        if (exitTime == null) {
            exitTime = new Date();
        }
        long durationInMillis = exitTime.getTime() - entryTime.getTime();
        return TimeUnit.MILLISECONDS.toHours(durationInMillis) + 1; // Ceiling function
    }

    // Getters
    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TicketStatus getStatus() {
        return status;
    }
}

// Entrance
class Entrance {
    private String entranceId;
    private TicketIssuer ticketIssuer;

    public Entrance(String entranceId) {
        this.entranceId = entranceId;
        this.ticketIssuer = new TicketIssuer();
    }

    public Ticket getTicket(Vehicle vehicle) {
        return ticketIssuer.issueTicket(vehicle);
    }
}

class TicketIssuer {
    public Ticket issueTicket(Vehicle vehicle) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingSpot spot = parkingLot.getParkingSpot(vehicle.getType());

        if (spot == null) {
            throw new RuntimeException("No parking spot available for vehicle type: " + vehicle.getType());
        }

        spot.assignVehicle(vehicle);
        return TicketFactory.createTicket(vehicle, spot);
    }
}

// Exit
class Exit {
    private String exitId;
    private PaymentProcessor paymentProcessor;

    public Exit(String exitId) {
        this.exitId = exitId;
        this.paymentProcessor = new PaymentProcessor();
    }

    public boolean processExit(Ticket ticket) {
        if (ticket.getStatus() != TicketStatus.PAID) {
            return false;
        }

        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.freeParkingSpot(ticket.getParkingSpot());
        return true;
    }
}

// Strategy Pattern for Pricing
interface PricingStrategy {
    double calculatePrice(Ticket ticket);
}

class HourlyPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Ticket ticket) {
        long duration = ticket.getParkingDurationInHours();
        VehicleType type = ticket.getVehicle().getType();
        double hourlyRate;

        switch (type) {
            case HANDICAP:
                hourlyRate = 1.0;
                break;
            case MOTORCYCLE:
                hourlyRate = 2.0;
                break;
            case CAR:
                hourlyRate = 3.0;
                break;
            case LARGE_VEHICLE:
                hourlyRate = 5.0;
                break;
            default:
                hourlyRate = 2.0;
        }

        return duration * hourlyRate;
    }
}

class DailyPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Ticket ticket) {
        long duration = ticket.getParkingDurationInHours();
        VehicleType type = ticket.getVehicle().getType();
        double dailyRate;

        switch (type) {
            case HANDICAP:
                dailyRate = 15.0;
                break;
            case MOTORCYCLE:
                dailyRate = 20.0;
                break;
            case CAR:
                dailyRate = 30.0;
                break;
            case LARGE_VEHICLE:
                dailyRate = 50.0;
                break;
            default:
                dailyRate = 25.0;
        }

        int days = (int) Math.ceil(duration / 24.0);
        return days * dailyRate;
    }
}

// Payment Processor
class PaymentProcessor {
    private PricingStrategy pricingStrategy;

    public PaymentProcessor() {
        this.pricingStrategy = new HourlyPricingStrategy(); // Default strategy
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public boolean processPayment(Ticket ticket) {
        ticket.markAsExited();
        double amount = pricingStrategy.calculatePrice(ticket);
        ticket.setAmount(amount);

        // Process payment logic here (e.g., credit card, cash)
        // For simplicity, we'll assume payment is successful

        ticket.markAsPaid();
        return true;
    }
}

// DisplayBoard - Observer Pattern
class DisplayBoard {
    private Map<VehicleType, Integer> availableSpots;

    public DisplayBoard() {
        this.availableSpots = new HashMap<>();
        for (VehicleType type : VehicleType.values()) {
            availableSpots.put(type, 0);
        }
    }

    public void updateAvailableSpots(VehicleType type, int count) {
        availableSpots.put(type, count);
        display();
    }

    private void display() {
        // Logic to display current availability
        System.out.println("Current Parking Availability:");
        for (Map.Entry<VehicleType, Integer> entry : availableSpots.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " spots");
        }
    }
}

// Main system controller - Command Pattern
interface Command {
    void execute();
}

class ParkVehicleCommand implements Command {
    private Entrance entrance;
    private Vehicle vehicle;
    private Ticket ticket;

    public ParkVehicleCommand(Entrance entrance, Vehicle vehicle) {
        this.entrance = entrance;
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        ticket = entrance.getTicket(vehicle);
        System.out.println("Vehicle parked: " + vehicle.getLicensePlate() + " with ticket: " + ticket.getTicketId());
    }

    public Ticket getTicket() {
        return ticket;
    }
}

class ExitVehicleCommand implements Command {
    private Exit exit;
    private Ticket ticket;

    public ExitVehicleCommand(Exit exit, Ticket ticket) {
        this.exit = exit;
        this.ticket = ticket;
    }

    @Override
    public void execute() {
        boolean success = exit.processExit(ticket);
        if (success) {
            System.out.println("Vehicle with ticket " + ticket.getTicketId() + " has exited");
        } else {
            System.out.println("Exit failed for ticket " + ticket.getTicketId());
        }
    }
}

class PaymentCommand implements Command {
    private PaymentProcessor paymentProcessor;
    private Ticket ticket;

    public PaymentCommand(PaymentProcessor paymentProcessor, Ticket ticket) {
        this.paymentProcessor = paymentProcessor;
        this.ticket = ticket;
    }

    @Override
    public void execute() {
        boolean success = paymentProcessor.processPayment(ticket);
        if (success) {
            System.out.println("Payment processed for ticket " + ticket.getTicketId() +
                    ". Amount: $" + ticket.getAmount());
        } else {
            System.out.println("Payment failed for ticket " + ticket.getTicketId());
        }
    }
}

// ParkingLotSystem class to initialize and run the system
public class ParkingLotSystem {
    public static void main(String[] args) {
        // Initialize Parking Lot
        ParkingLot parkingLot = ParkingLot.getInstance();

        // Create parking floors
        int numFloors = 5;
        int spotsPerFloor = 10000 / numFloors;

        for (int i = 1; i <= numFloors; i++) {
            ParkingFloor floor = new ParkingFloor("Floor-" + i);

            // Distribute different types of parking spots
            int handicapSpots = (int)(spotsPerFloor * 0.1); // 10% for handicap
            int motorcycleSpots = (int)(spotsPerFloor * 0.2); // 20% for motorcycles
            int largeVehicleSpots = (int)(spotsPerFloor * 0.1); // 10% for large vehicles
            int carSpots = spotsPerFloor - handicapSpots - motorcycleSpots - largeVehicleSpots; // 60% for cars

            // Create spots for each type
            for (int j = 1; j <= handicapSpots; j++) {
                floor.addParkingSpot(new ParkingSpot("H-" + i + "-" + j, VehicleType.HANDICAP));
            }

            for (int j = 1; j <= motorcycleSpots; j++) {
                floor.addParkingSpot(new ParkingSpot("M-" + i + "-" + j, VehicleType.MOTORCYCLE));
            }

            for (int j = 1; j <= largeVehicleSpots; j++) {
                floor.addParkingSpot(new ParkingSpot("L-" + i + "-" + j, VehicleType.LARGE_VEHICLE));
            }

            for (int j = 1; j <= carSpots; j++) {
                floor.addParkingSpot(new ParkingSpot("C-" + i + "-" + j, VehicleType.CAR));
            }

            parkingLot.addFloor(floor);
        }

        // Create entrances and exits
        for (int i = 1; i <= 4; i++) {
            parkingLot.addEntrance(new Entrance("Entrance-" + i));
            parkingLot.addExit(new Exit("Exit-" + i));
        }

        // Sample usage
        Vehicle car = VehicleFactory.createVehicle("ABC-123", VehicleType.CAR);
        Entrance entrance = parkingLot.getEntrances().get(0);

        ParkVehicleCommand parkCommand = new ParkVehicleCommand(entrance, car);
        parkCommand.execute();

        Ticket ticket = parkCommand.getTicket();

        // Process payment
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        PaymentCommand paymentCommand = new PaymentCommand(paymentProcessor, ticket);
        paymentCommand.execute();

        // Exit
        Exit exit = parkingLot.getExits().get(0);
        ExitVehicleCommand exitCommand = new ExitVehicleCommand(exit, ticket);
        exitCommand.execute();
    }
}