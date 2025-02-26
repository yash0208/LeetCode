package Graph.UndirectedGraph.Model;

/**
 * Represents an edge in a graph.
 */
public class Edge {
    private int src;         // Source vertex
    private int destination; // Destination vertex
    private int weight;      // Edge weight (default 0 for unweighted graphs)

    /**
     * Constructs an unweighted edge between two vertices.
     *
     * @param src        The source vertex.
     * @param destination The destination vertex.
     */
    public Edge(int src, int destination) {
        this.src = src;
        this.destination = destination;
        this.weight = 0; // Default weight
    }

    /**
     * Constructs a weighted edge between two vertices.
     *
     * @param src        The source vertex.
     * @param destination The destination vertex.
     * @param weight      The weight of the edge.
     */
    public Edge(int src, int destination, int weight) {
        this.src = src;
        this.destination = destination;
        this.weight = weight;
    }

    /**
     * Gets the source vertex.
     *
     * @return The source vertex.
     */
    public int getSrc() {
        return src;
    }

    /**
     * Sets the source vertex.
     *
     * @param src The new source vertex.
     */
    public void setSrc(int src) {
        this.src = src;
    }

    /**
     * Gets the destination vertex.
     *
     * @return The destination vertex.
     */
    public int getDestination() {
        return destination;
    }

    /**
     * Sets the destination vertex.
     *
     * @param destination The new destination vertex.
     */
    public void setDestination(int destination) {
        this.destination = destination;
    }

    /**
     * Gets the weight of the edge.
     *
     * @return The weight of the edge.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the edge.
     *
     * @param weight The new weight of the edge.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
