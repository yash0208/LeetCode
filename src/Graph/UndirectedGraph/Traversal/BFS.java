package Graph.UndirectedGraph.Traversal;

import Graph.UndirectedGraph.Implementation.ListImplementation;
import Graph.UndirectedGraph.Model.Graph;
import Graph.SupportingFunctions.MapPrint;

import java.util.*;

/**
 * This class demonstrates Breadth-First Search (BFS) traversal of an undirected graph.
 * The traversal is performed level-wise, storing nodes at each BFS depth level.
 */
public class BFS {
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

        // Perform BFS traversal
        List<List<Integer>> bfsList = bfsTraversal(mapUndirected, 1);

        // Print BFS levels
        System.out.println("BFS Traversal (Level-wise): ");
        for (int i = 0; i < bfsList.size(); i++) {
            System.out.println("Level " + (i + 1) + ": " + bfsList.get(i));
        }
    }

    /**
     * Performs Breadth-First Search (BFS) traversal on a graph.
     *
     * @param graph The adjacency list representation of the graph.
     * @param start The starting node for BFS traversal.
     * @return A list of lists, where each inner list represents a level in BFS.
     */
    public static List<List<Integer>> bfsTraversal(Map<Integer, List<Integer>> graph, int start) {
        List<List<Integer>> bfsLevels = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        // Start BFS traversal from the given node
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                int currentNode = queue.poll();
                level.add(currentNode);

                // Skip if node has no neighbors in the adjacency list
                if (!graph.containsKey(currentNode)) continue;

                for (Integer neighbor : graph.get(currentNode)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            // Add the current level to BFS result
            bfsLevels.add(level);
        }

        return bfsLevels;
    }
}
