package Graph.Traversal;

import Graph.Implementation.ListImplementation;
import Graph.Model.Graph;
import SupportingFunctions.MapPrint;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        // Create a sample graph
        Graph graph = new Graph();
        // To traverse, first we make a list from this graph
        ListImplementation listImplementation = new ListImplementation();
        Map<Integer, List<Integer>> mapUndirected = listImplementation.createUndirectedAdjacencyList(graph);

        // Print the adjacency list of the graph
        MapPrint mapPrint = new MapPrint();
        System.out.println();

        System.out.println("Graph Adjacency List: ");
        mapPrint.printAdjacencyList(mapUndirected);
        System.out.println();

        // List to hold the BFS traversal by levels
        List<List<Integer>> bfsList = new ArrayList<>();

        // Queue for BFS and visited array
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[graph.nodes + 1]; // Assuming nodes are 1-indexed

        // Start BFS from node 1 (or any other starting node)
        queue.add(1);
        visited[1] = 1; // Mark node as visited

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // Number of nodes at current level
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                int currentSrc = queue.poll();
                currentLevel.add(currentSrc);

                List<Integer> neighbors = mapUndirected.get(currentSrc);
                if (neighbors != null) {
                    for (int neighbor : neighbors) {
                        if (visited[neighbor] == 0) { // If not visited
                            queue.add(neighbor);
                            visited[neighbor] = 1; // Mark as visited
                        }
                    }
                }
            }
            bfsList.add(currentLevel); // Add all nodes of current level
        }

        // Print the BFS traversal result by levels
        System.out.println("BFS Traversal by Levels: ");
        for (List<Integer> level : bfsList) {
            System.out.println(level);
        }
    }
}
