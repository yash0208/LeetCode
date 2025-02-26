# Graph Model (Edge List Representation)

This package implements a **graph data structure** using an **edge list representation** in Java. It provides a simple way to create, manage, and print graph edges.

## 📌 Features
- **Edge class** to represent connections between nodes.
- **Graph class** to store and manipulate edges.
- **Supports both weighted and unweighted edges**.
- **Maintains in-degree and out-degree for each node**.
- **Edge list representation** (efficient for sparse graphs).

## 📂 Files Overview

### 1️⃣ Edge.java
- Defines the **Edge** class, representing a connection between two nodes.
- Supports **both directed and weighted edges**.

### 2️⃣ Graph.java
- Implements a **graph** using an **edge list**.
- Allows adding edges dynamically.
- Maintains **in-degree and out-degree counts** for each node.
- Prints all edges in the graph.

## 🏗️ Graph Representation

This implementation uses an **edge list**, meaning the graph is stored as a list of edges.

### Example:
Consider a graph with **5 nodes (1, 2, 3, 4, 5)** and the following edges:
- **1 → 2**
- **1 → 3**
- **2 → 4**
- **3 → 4**
- **4 → 5**

#### 📌 Edge List Representation:
```
1 → 2
1 → 3
2 → 4
3 → 4
4 → 5
```

#### 📊 In-Degree & Out-Degree Representation:
```
Node 1: Out-degree = 2, In-degree = 0
Node 2: Out-degree = 1, In-degree = 1
Node 3: Out-degree = 1, In-degree = 1
Node 4: Out-degree = 1, In-degree = 2
Node 5: Out-degree = 0, In-degree = 1
```

## 🔨 Usage

### **1️⃣ Creating a Graph**
To use this graph model, create a new `Graph` instance:
```java
Graph graph = new Graph();
```
This initializes a graph with predefined edges.

### **2️⃣ Adding an Edge**
You can manually add an edge using:
```java
graph.addEdge(2, 5);
```

### **3️⃣ Printing Edges**
Print all edges in the graph:
```java
graph.printEdges();
```

### **4️⃣ Getting In-Degree & Out-Degree**
Check the in-degree and out-degree of a node:
```java
int inDegree = graph.getInDegree(4);
int outDegree = graph.getOutDegree(4);
```
