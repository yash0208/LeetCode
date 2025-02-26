package Graph.DirectedGraph.Implementation;

import Graph.DirectedGraph.Model.Edge;
import Graph.DirectedGraph.Model.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implements the adjacency list representation of a directed graph.
 */
public class ListImplementation {
    /**
     * Creates and returns the adjacency list for a directed graph.
     *
     * @param graph The input graph represented as an edge list.
     * @return A map representing the adjacency list of the directed graph.
     */
    public Map<Integer, List<Integer>> createDirectedAdjacencyList(Graph graph) {
        Map<Integer, List<Integer>> mapDirected = new HashMap<>();

        // Traverse the edge list to add neighbors
        for (Edge e : graph.edges) {
            int a = e.getSrc();
            int b = e.getDestination();

            mapDirected.putIfAbsent(a, new ArrayList<>());

            // Add only one direction for a directed graph
            mapDirected.get(a).add(b);
        }

        return mapDirected;
    }
}
