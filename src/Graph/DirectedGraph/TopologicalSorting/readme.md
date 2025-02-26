
# Topological Sorting (Directed Graph)

## Overview
This implementation uses **Kahn's Algorithm** to perform topological sorting on a directed graph. Topological sorting produces a linear ordering of vertices such that for every directed edge `uv`, vertex `u` comes before vertex `v`.

## Graph Representation
- The graph is represented using an **edge list**.
- An **adjacency list** is built from the edge list for efficient traversal.
- **In-degree** information for each node is maintained and updated during the sorting process.

### Example Directed Graph:
Consider a directed graph with **5 nodes (1, 2, 3, 4, 5)** and the following edges:
- **1 → 2**
- **1 → 3**
- **2 → 4**
- **3 → 4**
- **4 → 5**

#### 📌 Adjacency List Representation:
```
1 → [2, 3]
2 → [4]
3 → [4]
4 → [5]
5 → []
```

#### 📊 In-Degree Representation:
```
Node 1: In-degree = 0
Node 2: In-degree = 1
Node 3: In-degree = 1
Node 4: In-degree = 2
Node 5: In-degree = 1
```

## Kahn's Algorithm
1. **Calculate In-Degree**: For each node, count the number of incoming edges.
2. **Initialize Queue**: Enqueue all nodes with in-degree 0.
3. **Process Queue**:
   - Remove a node from the queue and add it to the topological order.
   - For each neighbor of the removed node, decrement its in-degree.
   - If a neighbor's in-degree becomes 0, enqueue it.
4. **Cycle Detection**: If the topological order contains fewer nodes than present in the graph, a cycle exists.

## Usage
1. **Graph Initialization**: Create a `Graph` instance with predefined edges.
2. **Topological Sorting**: Run the `TopologicalSorting` class to compute and print the topological order.
3. **Cycle Detection**: The algorithm prints a message if the graph contains a cycle.

### Code Example:
```java
Graph graph = new Graph();
TopologicalSorting.main(new String[0]);
```

## Complexity
- **Time Complexity**: O(V + E)
- **Space Complexity**: O(V)

## Conclusion
This implementation efficiently computes a valid topological order for a directed acyclic graph (DAG) using Kahn's Algorithm. If the graph has a cycle, the algorithm reports that topological sorting is not possible.
```

---