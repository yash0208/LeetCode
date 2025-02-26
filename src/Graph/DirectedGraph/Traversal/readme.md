
# 📌 **Graph Traversal: BFS & DFS in Directed Graphs**

## 🔹 **What is Graph Traversal?**
Graph traversal refers to the process of visiting all nodes (or vertices) in a graph systematically. The two most common traversal techniques are:

1. **Breadth-First Search (BFS)** – Explores neighbors first before going deeper.
2. **Depth-First Search (DFS)** – Explores as deep as possible before backtracking.

---

## **1️⃣ Breadth-First Search (BFS)**

### 🔹 **Concept**
BFS explores a graph **level by level**, ensuring that all nodes at the current depth are visited before moving deeper. It is implemented using a **queue (FIFO – First In, First Out)**.

---

### 🔹 **Graph Example (Directed)**

Consider the following directed graph:

```
      1 → 2 → 4
      ↓  
      3 → 5 → 6
```

### 🔹 **Adjacency List Representation**
```
1 -> [2, 3]
2 -> [4]
3 -> [5]
4 -> []
5 -> [6]
6 -> []
```

### 🔹 **BFS Traversal (Starting from Node 1)**
1️⃣ Start at **node 1**, mark as **visited**, and enqueue: `[1]`  
2️⃣ Dequeue **1**, visit neighbors **2 & 3**, enqueue: `[2, 3]`  
3️⃣ Dequeue **2**, visit neighbor **4**, enqueue: `[3, 4]`  
4️⃣ Dequeue **3**, visit neighbor **5**, enqueue: `[4, 5]`  
5️⃣ Dequeue **4**, no new neighbors  
6️⃣ Dequeue **5**, visit neighbor **6**, enqueue: `[6]`  
7️⃣ Dequeue **6**, no new neighbors  

✅ **Final BFS Order:** `1 → 2 → 3 → 4 → 5 → 6`

---

### 🔹 **Logic for BFS Traversal**
1. Initialize a **queue** and mark the starting node as **visited**.
2. While the queue is not empty:
    - Remove the front node and process it.
    - Add all its **unvisited** neighbors to the queue.
    - Mark them as **visited**.

---

## **2️⃣ Depth-First Search (DFS)**

### 🔹 **Concept**
DFS explores a graph **as deep as possible**, visiting a node’s neighbors **recursively** before backtracking. It is implemented using a **stack (LIFO – Last In, First Out)** or **recursion**.

---

### 🔹 **Graph Example (Same as BFS)**

```
      1 → 2 → 4
      ↓  
      3 → 5 → 6
```

### 🔹 **Adjacency List Representation**
```
1 -> [2, 3]
2 -> [4]
3 -> [5]
4 -> []
5 -> [6]
6 -> []
```

### 🔹 **DFS Traversal (Starting from Node 1)**
1️⃣ Start at **node 1**, mark as **visited**.  
2️⃣ Move to **neighbor 2**, mark as **visited**.  
3️⃣ Move to **neighbor 4**, mark as **visited**.  
4️⃣ No more neighbors → **Backtrack to 1**.  
5️⃣ Move to **neighbor 3**, mark as **visited**.  
6️⃣ Move to **neighbor 5**, mark as **visited**.  
7️⃣ Move to **neighbor 6**, mark as **visited**.  
8️⃣ No more neighbors → **Traversal complete**.

✅ **Final DFS Order:** `1 → 2 → 4 → 3 → 5 → 6`

---

### 🔹 **Logic for DFS Traversal**
1. **Recursive Approach:**
    - Start at the given node and mark it **visited**.
    - Recursively visit each **unvisited** neighbor.
    - Backtrack when no more unvisited neighbors remain.

2. **Stack-Based Approach:**
    - Initialize a **stack** with the starting node.
    - While the stack is not empty:
        - Pop the top node, mark as **visited**, and process it.
        - Push all **unvisited** neighbors onto the stack.

---

## **📌 BFS vs DFS: When to Use?**

| Feature            | BFS (Breadth-First Search) | DFS (Depth-First Search) |
|--------------------|--------------------------|--------------------------|
| **Data Structure** | Queue (FIFO)             | Stack (LIFO) or Recursion |
| **Traversal Order** | Level-by-level           | Deep first, then backtrack |
| **Handles Cycles?** | Yes, but must track visited nodes | Yes, but must track visited nodes |
| **Shortest Path?** | Yes (in unweighted graphs) | No |
| **Space Complexity** | O(V) (stores all nodes in queue) | O(V) (recursion stack) |
| **Best for?** | Finding shortest paths, level-order traversal | Exploring all paths, detecting cycles |

---

## **🎯 Summary**
✅ **BFS** explores level by level using a **queue**.  
✅ **DFS** explores depth-first using **recursion or a stack**.  
✅ **BFS** is better for finding the **shortest path** in unweighted graphs.  
✅ **DFS** is better for problems requiring **complete exploration**.

---
