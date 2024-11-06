package Graph.Implementation;

import Graph.Model.Edge;
import Graph.Model.Graph;
import SupportingFunctions.MapPrint;
import SupportingFunctions.MatrixPrint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListImplementation {
    // Method to create and return the adjacency list for an undirected graph
    public Map<Integer, List<Integer>> createUndirectedAdjacencyList(Graph graph) {
        Map<Integer, List<Integer>> mapUndirected = new HashMap<>();

        // Traverse the edge list to add neighbors
        for (Edge e : graph.edges) {
            int a = e.getSrc();
            int b = e.getDestination();

            mapUndirected.putIfAbsent(a, new ArrayList<>());
            mapUndirected.putIfAbsent(b, new ArrayList<>());

            // Add both directions for undirected graph
            mapUndirected.get(a).add(b);
            mapUndirected.get(b).add(a);
        }

        return mapUndirected;
    }

    // Method to create and return the adjacency list for a directed graph
    public Map<Integer, List<Integer>> createDirectedAdjacencyList(Graph graph) {
        Map<Integer, List<Integer>> mapDirected = new HashMap<>();

        // Traverse the edge list to add neighbors
        for (Edge e : graph.edges) {
            int a = e.getSrc();
            int b = e.getDestination();

            mapDirected.putIfAbsent(a, new ArrayList<>());

            // Add only one direction for directed graph
            mapDirected.get(a).add(b);
        }

        return mapDirected;
    }
}
