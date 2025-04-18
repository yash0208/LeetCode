package Graph.UndirectedGraph.Implementation;

import Graph.UndirectedGraph.Model.Edge;
import Graph.UndirectedGraph.Model.Graph;

/**
 * Implements the adjacency matrix representation of a graph.
 */
public class MatrixImplementation {

    /**
     * Creates and returns the adjacency matrix for an undirected graph.
     *
     * @param graph The input graph represented as an edge list.
     * @return A 2D array representing the adjacency matrix of the undirected graph.
     */
    public int[][] createUndirectedMatrix(Graph graph) {
        int[][] matrixUndirected = new int[graph.nodes + 1][graph.nodes + 1];

        // Fill the matrix for an undirected graph
        for (Edge e : graph.edges) {
            int a = e.getSrc();
            int b = e.getDestination();

            matrixUndirected[a][b] = 1;
            matrixUndirected[b][a] = 1;  // Add both directions
        }

        return matrixUndirected;
    }


}
