package Graph.DirectedGraph.Model;

import java.util.*;

/**
 * Represents a directed graph using an edge list and tracks in-degree and out-degree.
 */
public class Graph {
    public List<Edge> edges;       // List of edges in the graph
    private int nodes;              // Number of nodes in the graph
    private Map<Integer, Integer> inDegree;   // Tracks in-degree of each node
    private Map<Integer, Integer> outDegree;  // Tracks out-degree of each node

    /**
     * Constructs a graph with a predefined set of edges.
     */
    public Graph() {
        this.edges = new ArrayList<>();
        this.inDegree = new HashMap<>();
        this.outDegree = new HashMap<>();
        this.nodes = 0;

        // Sample edges
        this.addEdge(1, 2);
        this.addEdge(1, 3);
        this.addEdge(2, 4);
        this.addEdge(3, 4);
        this.addEdge(4, 5);
        this.nodes = 5;
        this.printEdges();
        this.printDegrees();
    }

    /**
     * Adds an unweighted edge to the graph and updates in-degree and out-degree.
     *
     * @param src  The source vertex.
     * @param dest The destination vertex.
     */
    public void addEdge(int src, int dest) {
        edges.add(new Edge(src, dest));

        // Update out-degree
        outDegree.put(src, outDegree.getOrDefault(src, 0) + 1);

        // Update in-degree
        inDegree.put(dest, inDegree.getOrDefault(dest, 0) + 1);

        // Ensure all nodes exist in maps
        inDegree.putIfAbsent(src, 0);
        outDegree.putIfAbsent(dest, 0);
    }

    /**
     * Prints all edges in the graph.
     */
    public void printEdges() {
        for (Edge edge : edges) {
            System.out.println("Edge from " + edge.getSrc() + " to " + edge.getDestination());
        }
    }

    /**
     * Prints in-degree and out-degree of each node.
     */
    public void printDegrees() {
        System.out.println("Node Degrees:");
        for (int node : inDegree.keySet()) {
            System.out.println("Node " + node + " -> In-degree: " + inDegree.get(node) + ", Out-degree: " + outDegree.get(node));
        }
    }
}
