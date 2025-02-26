# ValidPath (Directed Graph Traversal)

This package implements path validation in a **directed graph** using **DFS and BFS**.

## 📌 Features
- **DFS-based path validation**
- **BFS-based path validation**
- **Handles directed graphs**

## 📂 Files Overview

### 1️⃣ ValidPath.java
- Implements **DFS and BFS** to check if a path exists between two nodes in a directed graph.

## 🏗️ Graph Representation

The directed graph is stored as an **adjacency list**.

### Example:
Consider a directed graph with **5 nodes (0, 1, 2, 3, 4)** and edges:
- **0 → 1**
- **1 → 2**
- **2 → 3**
- **3 → 4**

#### 📌 Adjacency List Representation:
```
0 → [1]
1 → [2]
2 → [3]
3 → [4]
```

## 🔨 Usage

### **1️⃣ Checking Path using DFS**
```java
ValidPath vp = new ValidPath();
int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
boolean exists = vp.validPathDFS(5, edges, 0, 4);
System.out.println(exists); // true
```

### **2️⃣ Checking Path using BFS**
```java
boolean existsBFS = vp.validPathBFS(5, edges, 0, 4);
System.out.println(existsBFS); // true
```
