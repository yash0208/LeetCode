package Graph.Model;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public List<Edge> edges;
    public int nodes;

    public Graph() {
        this.edges = new ArrayList<>();
        this.addEdge(1, 2);
        this.addEdge(1, 3);
        this.addEdge(2, 4);
        this.addEdge(3, 4);
        this.addEdge(4, 5);
        nodes=5;
        this.printEdges();
    }

    public void addEdge(int src, int dest) {
        edges.add(new Edge(src, dest));
    }

    public void printEdges() {
        for (Edge edge : edges) {
            System.out.println("Edge from " + edge.src + " to " + edge.destination);
        }
    }

}
