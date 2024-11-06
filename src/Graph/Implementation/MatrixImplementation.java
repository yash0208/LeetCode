package Graph.Implementation;

import Graph.Model.Edge;
import Graph.Model.Graph;
import SupportingFunctions.MatrixPrint;

import java.util.ArrayList;
import java.util.List;

public class MatrixImplementation {
    // Method to create and return the adjacency matrix for an undirected graph
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

    // Method to create and return the adjacency matrix for a directed graph
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
