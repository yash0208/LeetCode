package Graph.DirectedGraph.Traversal.ValidPath;

import java.util.*;

/**
 * This class provides two methods (DFS & BFS) to determine whether a valid path exists between two nodes in a directed graph.
 */
public class ValidPath {

    /**
     * Determines if there is a valid path between source and destination using DFS.
     *
     * @param n         The number of nodes in the graph (0-based indexing).
     * @param edges     The list of edges where each edge connects two nodes.
     * @param source    The starting node.
     * @param destination The target node.
     * @return true if a path exists, false otherwise.
     */
    public boolean validPathDFS(int n, int[][] edges, int source, int destination) {
        // Build adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        // Perform DFS
        Set<Integer> visited = new HashSet<>();
        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(Map<Integer, List<Integer>> graph, int current, int destination, Set<Integer> visited) {
        if (current == destination) return true;
        if (visited.contains(current)) return false;

        visited.add(current);
        for (int neighbor : graph.get(current)) {
            if (dfs(graph, neighbor, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if there is a valid path between source and destination using BFS.
     *
     * @param n         The number of nodes in the graph (0-based indexing).
     * @param edges     The list of edges where each edge connects two nodes.
     * @param source    The starting node.
     * @param destination The target node.
     * @return true if a path exists, false otherwise.
     */
    public boolean validPathBFS(int n, int[][] edges, int source, int destination) {
        // Build adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        // Perform BFS
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == destination) return true;

            for (int neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}