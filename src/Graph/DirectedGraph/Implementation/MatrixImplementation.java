package Graph.DirectedGraph.Implementation;

import Graph.UndirectedGraph.Model.Edge;
import Graph.UndirectedGraph.Model.Graph;

/**
 * Implements the adjacency matrix representation of a directed graph.
 */
public class MatrixImplementation {
    /**
     * Creates and returns the adjacency matrix for a directed graph.
     *
     * @param graph The input graph represented as an edge list.
     * @return A 2D array representing the adjacency matrix of the directed graph.
     */
    public int[][] createDirectedMatrix(Graph graph) {
        int[][] matrixDirected = new int[graph.nodes + 1][graph.nodes + 1];

        // Fill the matrix for a directed graph
        for (Edge e : graph.edges) {
            int a = e.getSrc();
            int b = e.getDestination();

            matrixDirected[a][b] = 1;  // Add only one direction
        }

        return matrixDirected;
    }
}
