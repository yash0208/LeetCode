package AUDAYDEV;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantVSZombie {
    /**
     * Simulates the Plants vs Zombie Ants scenario and returns the number of nights
     * until plants stop dying.
     *
     * @param plants List of integers representing the number of zombie ants in each plant
     * @return Number of nights until plants stop dying
     */
    public static int nightsUntilStable(List<Integer> plants) {
        int nights = 0;
        boolean plantsDied = true;

        while (plantsDied && !plants.isEmpty()) {
            plantsDied = false;
            List<Integer> survivingPlants = new ArrayList<>();

            // The first plant always survives due to infinite antidote
            survivingPlants.add(plants.get(0));
            int antidote = plants.get(0);  // Antidote for the next plant

            // Check each plant (except the first one)
            for (int i = 1; i < plants.size(); i++) {
                if (plants.get(i) <= antidote) {  // Plant survives
                    survivingPlants.add(plants.get(i));
                    antidote = plants.get(i);  // Update antidote for the next plant
                } else {  // Plant dies
                    plantsDied = true;
                    // No antidote passes from this plant
                }
            }

            // If any plant died, we have a new arrangement for the next night
            if (plantsDied) {
                nights++;
                plants = survivingPlants;
            }
        }

        return nights + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> plants = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            plants.add(scanner.nextInt());
        }

        System.out.println(nightsUntilStable(plants));
        scanner.close();
    }

    // Test method to verify the solution with the given examples
    public static void test() {
        List<List<Integer>> testCases = new ArrayList<>();
        List<Integer> testCase1 = List.of(3, 6, 2, 7, 5);
        List<Integer> testCase2 = List.of(6, 5, 8, 4, 7, 10, 9);
        testCases.add(testCase1);
        testCases.add(testCase2);

        int[] expectedResults = {2, 2};

        for (int i = 0; i < testCases.size(); i++) {
            List<Integer> plants = new ArrayList<>(testCases.get(i));
            int result = nightsUntilStable(plants);
            System.out.println("Test case " + (i+1) + ": Plants " + testCases.get(i));
            System.out.println("Result: " + result + ", Expected: " + expectedResults[i]);
            System.out.println(result == expectedResults[i] ? "Passed" : "Failed");
            System.out.println("-".repeat(50));
        }
    }
    }