package Graph.Model;

public class Edge {
    int src;
    int destination;
    int weight;

    public Edge(int src, int destination) {
        this.src = src;
        this.destination = destination;
        this.weight=0;
    }

    public Edge(int src, int destination, int weight) {
        this.src = src;
        this.destination = destination;
        this.weight = weight;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
