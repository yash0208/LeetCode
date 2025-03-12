package AmazonInterview.Graph.DFS;

import java.util.*;

public class ReconstructItinerary {

    public List<String> findItinerary(List<List<String>> tickets) {
        // Build the graph: origin -> (min-heap of destinations)
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        // Use a LinkedList to easily add nodes to the front (reverse order)
        LinkedList<String> itinerary = new LinkedList<>();
        dfs("JFK", graph, itinerary);
        return itinerary;
    }

    // Recursive DFS function to traverse the graph and build the itinerary
    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> itinerary) {
        PriorityQueue<String> nextAirports = graph.get(airport);
        while (nextAirports != null && !nextAirports.isEmpty()) {
            String next = nextAirports.poll();
            dfs(next, graph, itinerary);
        }
        // Add airport to the front of itinerary after visiting all its edges
        itinerary.addFirst(airport);
    }
}
