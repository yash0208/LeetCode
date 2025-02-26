package Graph.DirectedGraph.TopologicalSorting;

import Graph.DirectedGraph.Model.Graph;
import Graph.DirectedGraph.Model.Edge;
import java.util.*;

/**
 * This class implements Topological Sorting for a directed graph using Kahn's Algorithm.
 * It processes nodes with zero in-degree, updates the in-degrees of adjacent nodes,
 * and builds a topological order. If the graph contains a cycle, topological sorting is not possible.
 */
public class TopologicalSorting {
    public static void main(String[] args) {
        // Create a graph with predefined edges
        Graph graph = new Graph();

        // Build an adjacency list from the graph's edge list
        int n = graph.getNodes(); // Assume nodes are numbered from 1 to n
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (Edge edge : graph.getEdges()) {
            int u = edge.getSrc();
            int v = edge.getDestination();
            adj.get(u).add(v);
        }

        // Copy the in-degree map from the graph
        Map<Integer, Integer> inDegree = new HashMap<>(graph.getInDegree());

        // Initialize the queue with nodes that have in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree.getOrDefault(i, 0) == 0) {
                queue.offer(i);
            }
        }

        // Perform Kahn's algorithm for topological sorting
        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            topoOrder.add(u);
            // For each neighbor v of u, decrement its in-degree and add to queue if it becomes 0
            for (int v : adj.get(u)) {
                inDegree.put(v, inDegree.get(v) - 1);
                if (inDegree.get(v) == 0) {
                    queue.offer(v);
                }
            }
        }

        // If topological order does not contain all nodes, then the graph has a cycle.
        if (topoOrder.size() != n) {
            System.out.println("Graph has a cycle. Topological sort not possible.");
        } else {
            System.out.println("Topological Order: " + topoOrder);
        }
    }
}
