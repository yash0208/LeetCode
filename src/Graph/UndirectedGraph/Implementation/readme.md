# Undirected Graph Implementation

## Overview
This project implements **undirected graphs** using both adjacency list and adjacency matrix representations.  
An **undirected graph** consists of nodes connected by edges **without direction**, meaning if there is an edge between `A` and `B`, you can travel in **both** directions.

## Visual Representation

Consider the following undirected graph:

```
    1 --- 2
    | \   |
    |  \  |
    3 --- 4
```

- `1 --- 2` means there is an **undirected** edge between `1` and `2`
- `1 --- 3` means there is an **undirected** edge between `1` and `3`
- `1 --- 4` means there is an **undirected** edge between `1` and `4`
- `2 --- 4` means there is an **undirected** edge between `2` and `4`
- `3 --- 4` means there is an **undirected** edge between `3` and `4`

### Adjacency List Representation

Using an **Adjacency List**, the graph can be represented as:

```
1 -> [2, 3, 4]
2 -> [1, 4]
3 -> [1, 4]
4 -> [1, 2, 3]
```

### Adjacency Matrix Representation

Using an **Adjacency Matrix**, the graph can be represented as:

```
    1  2  3  4
  --------------
1 | 0  1  1  1
2 | 1  0  0  1
3 | 1  0  0  1
4 | 1  1  1  0
```

- `matrix[i][j] = 1` indicates an **undirected edge** between nodes `i` and `j`
- `matrix[i][j] = 0` means no direct edge exists

---

## Implementations

### 1. Adjacency List (`ListImplementation.java`)
- Uses a `HashMap<Integer, List<Integer>>` to store edges.
- Each node maintains a list of **all connected nodes**.

Example usage:
```java
Map<Integer, List<Integer>> adjacencyList = createUndirectedAdjacencyList(graph);
```

### 2. Adjacency Matrix (`MatrixImplementation.java`)
- Uses a **2D array**, where `matrix[i][j] = 1` if there is an **undirected edge** between nodes `i` and `j`.

Example usage:
```java
int[][] adjacencyMatrix = createUndirectedMatrix(graph);
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

Map<Integer, List<Integer>> adjacencyList = listImpl.createUndirectedAdjacencyList(graph);
int[][] adjacencyMatrix = matrixImpl.createUndirectedMatrix(graph);
```

---

## Time Complexity
- **Adjacency List**
   - Space: **O(V + E)**
   - Edge Lookup: **O(V)**
- **Adjacency Matrix**
   - Space: **O(V²)**
   - Edge Lookup: **O(1)**

---
