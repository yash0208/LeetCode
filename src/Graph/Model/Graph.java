package Graph.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a graph using an edge list.
 */
public class Graph {
    public List<Edge> edges; // List of edges in the graph
    public int nodes;        // Number of nodes in the graph

    /**
     * Constructs a graph with a predefined set of edges.
     */
    public Graph() {
        this.edges = new ArrayList<>();
        this.addEdge(1, 2);
        this.addEdge(1, 3);
        this.addEdge(2, 4);
        this.addEdge(3, 4);
        this.addEdge(4, 5);
        this.nodes = 5;
        this.printEdges();
    }

    /**
     * Adds an unweighted edge to the graph.
     *
     * @param src  The source vertex.
     * @param dest The destination vertex.
     */
    public void addEdge(int src, int dest) {
        edges.add(new Edge(src, dest));
    }

    /**
     * Prints all edges in the graph.
     */
    public void printEdges() {
        for (Edge edge : edges) {
            System.out.println("Edge from " + edge.getSrc() + " to " + edge.getDestination());
        }
    }
}
