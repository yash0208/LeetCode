# Directed Graph Implementation

## Overview
This project implements directed graphs using both adjacency list and adjacency matrix representations. A **directed graph** consists of nodes connected by edges that have a specific direction.

## Visual Representation

Consider the following directed graph:

```
    1 → 2 → 4
    ↓    ↓
    3 → 5
```

- `1 → 2` means there is a directed edge from `1` to `2`
- `1 → 3` means there is a directed edge from `1` to `3`
- `2 → 4` means there is a directed edge from `2` to `4`
- `2 → 5` means there is a directed edge from `2` to `5`
- `3 → 5` means there is a directed edge from `3` to `5`

### Adjacency List Representation

Using an **Adjacency List**, the graph can be represented as:

```
1 -> [2, 3]
2 -> [4, 5]
3 -> [5]
4 -> []
5 -> []
```

### Adjacency Matrix Representation

Using an **Adjacency Matrix**, the graph can be represented as:

```
    1  2  3  4  5
  ----------------
1 | 0  1  1  0  0
2 | 0  0  0  1  1
3 | 0  0  0  0  1
4 | 0  0  0  0  0
5 | 0  0  0  0  0
```

- `matrix[i][j] = 1` indicates a directed edge from node `i` to node `j`
- `matrix[i][j] = 0` means no direct edge exists

---

## Implementations

### 1. Adjacency List (`ListImplementation.java`)
- Uses a `HashMap<Integer, List<Integer>>` to store edges.
- Each node stores a list of nodes it has directed edges to.

Example usage:
```java
Map<Integer, List<Integer>> adjacencyList = createDirectedAdjacencyList(graph);
```

### 2. Adjacency Matrix (`MatrixImplementation.java`)
- Uses a 2D array where `matrix[i][j] = 1` if an edge from `i` to `j` exists.

Example usage:
```java
int[][] adjacencyMatrix = createDirectedMatrix(graph);
```

---

## Usage
1. Create a `Graph` object with edges.
2. Use `ListImplementation` to generate an adjacency list.
3. Use `MatrixImplementation` to generate an adjacency matrix.

Example:
```java
Graph graph = new Graph();
ListImplementation listImpl = new ListImplementation();
MatrixImplementation matrixImpl = new MatrixImplementation();

Map<Integer, List<Integer>> adjacencyList = listImpl.createDirectedAdjacencyList(graph);
int[][] adjacencyMatrix = matrixImpl.createDirectedMatrix(graph);
```

---

## Time Complexity
- **Adjacency List**
    - Space: **O(V + E)**
    - Edge Lookup: **O(V)**
- **Adjacency Matrix**
    - Space: **O(V²)**
    - Edge Lookup: **O(1)**
