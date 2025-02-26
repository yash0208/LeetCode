package Graph.DirectedGraph.Model;

import java.util.*;

/**
 * Represents a directed graph using an edge list and tracks in-degree and out-degree.
 */
public class Graph {
    public List<Edge> edges;                     // List of edges in the graph
    public int nodes;                            // Number of nodes in the graph
    public Map<Integer, Integer> inDegree;       // Tracks in-degree of each node
    public Map<Integer, Integer> outDegree;      // Tracks out-degree of each node

    /**
     * Constructs a graph with a predefined set of edges.
     * The sample graph includes nodes 1 to 5 with the following edges:
     * 1 → 2, 1 → 3, 2 → 4, 3 → 4, 4 → 5.
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
     * Adds an unweighted edge to the graph and updates the in-degree and out-degree counts.
     *
     * @param src  The source vertex.
     * @param dest The destination vertex.
     */
    public void addEdge(int src, int dest) {
        edges.add(new Edge(src, dest));

        // Update out-degree for source
        outDegree.put(src, outDegree.getOrDefault(src, 0) + 1);

        // Update in-degree for destination
        inDegree.put(dest, inDegree.getOrDefault(dest, 0) + 1);

        // Ensure all nodes exist in the maps (even if they have no incoming/outgoing edges)
        inDegree.putIfAbsent(src, 0);
        outDegree.putIfAbsent(dest, 0);
    }

    /**
     * Returns the list of edges in the graph.
     *
     * @return The list of edges.
     */
    public List<Edge> getEdges() {
        return edges;
    }

    /**
     * Returns the number of nodes in the graph.
     *
     * @return The number of nodes.
     */
    public int getNodes() {
        return nodes;
    }

    /**
     * Returns the in-degree map of the graph.
     *
     * @return A map where keys are nodes and values are their in-degrees.
     */
    public Map<Integer, Integer> getInDegree() {
        return inDegree;
    }

    /**
     * Returns the out-degree map of the graph.
     *
     * @return A map where keys are nodes and values are their out-degrees.
     */
    public Map<Integer, Integer> getOutDegree() {
        return outDegree;
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
     * Prints the in-degree and out-degree of each node in the graph.
     */
    public void printDegrees() {
        System.out.println("Node Degrees:");
        // Combine keys from both maps to get all nodes
        Set<Integer> allNodes = new HashSet<>();
        allNodes.addAll(inDegree.keySet());
        allNodes.addAll(outDegree.keySet());
        for (int node : allNodes) {
            int in = inDegree.getOrDefault(node, 0);
            int out = outDegree.getOrDefault(node, 0);
            System.out.println("Node " + node + " -> In-degree: " + in + ", Out-degree: " + out);
        }
    }
}
