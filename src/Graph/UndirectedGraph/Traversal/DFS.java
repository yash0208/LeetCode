package Graph.UndirectedGraph.Traversal;

import Graph.UndirectedGraph.Implementation.ListImplementation;
import Graph.UndirectedGraph.Model.Graph;
import Graph.SupportingFunctions.MapPrint;

import java.util.*;

/**
 * This class demonstrates Depth-First Search (DFS) traversal of an undirected graph.
 * The traversal explores each branch fully before backtracking.
 */
public class DFS {
    public static void main(String[] args) {
        // Create a sample graph
        Graph graph = new Graph();

        // Convert graph to adjacency list representation
        ListImplementation listImplementation = new ListImplementation();
        Map<Integer, List<Integer>> mapUndirected = listImplementation.createUndirectedAdjacencyList(graph);

        // Print the adjacency list of the graph
        MapPrint mapPrint = new MapPrint();
        System.out.println("\nGraph Adjacency List: ");
        mapPrint.printAdjacencyList(mapUndirected);
        System.out.println();

        // Perform DFS traversal
        List<Integer> dfsTraversalResult = dfs(mapUndirected, 1);

        // Print DFS result
        System.out.println("DFS Traversal Order: " + dfsTraversalResult);
    }

    /**
     * Performs Depth-First Search (DFS) traversal on a graph.
     *
     * @param graph The adjacency list representation of the graph.
     * @param start The starting node for DFS traversal.
     * @return A list representing the DFS traversal order.
     */
    public static List<Integer> dfs(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> traversalOrder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        // Start DFS traversal from the given node
        stack.push(start);
        visited.add(start);

        while (!stack.isEmpty()) {
            int current = stack.pop();
            traversalOrder.add(current);

            // Check if the current node has neighbors
            if (!graph.containsKey(current)) continue;

            // Process neighbors in reverse order for correct DFS behavior
            List<Integer> neighbors = graph.get(current);
            Collections.reverse(neighbors); // Ensures left-to-right DFS order

            for (Integer neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return traversalOrder;
    }
}
