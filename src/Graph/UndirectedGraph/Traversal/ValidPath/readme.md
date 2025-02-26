# Valid Path in an Undirected Graph

## Problem Statement
Given an **undirected** graph with `n` nodes (labeled from `0` to `n-1`) and an **edge list**, determine if there is a valid path between two given nodes: `source` and `destination`.

## Approach
We use **both DFS (Depth-First Search) and BFS (Breadth-First Search)** to check if a path exists between `source` and `destination`.

### 1. **Depth-First Search (DFS)**
- We represent the graph using an **adjacency list**.
- Use **recursion** to traverse all connected nodes.
- If the destination is found during traversal, return `true`.
- Maintain a **visited set** to prevent cycles.

### 2. **Breadth-First Search (BFS)**
- Use a **queue** to explore neighbors level by level.
- If the destination node is reached, return `true`.
- Maintain a **visited set** to track explored nodes.

## Example
Consider the following undirected graph:

```
    0 -- 1 -- 2
    |         |
    3 ------- 4
```

### **Input:**
```plaintext
n = 5
edges = [[0,1], [1,2], [0,3], [3,4], [2,4]]
source = 0
destination = 4
```

### **Adjacency List Representation:**
```plaintext
0 -> [1, 3]
1 -> [0, 2]
2 -> [1, 4]
3 -> [0, 4]
4 -> [3, 2]
```

### **DFS Traversal:**
```plaintext
Start at 0 → Visit 1 → Visit 2 → Reach 4 ✅
```

### **BFS Traversal:**
```plaintext
Start at 0 → Add [1, 3] to queue
Visit 1 → Add 2 to queue
Visit 3 → Add 4 to queue
Visit 2 → Add 4 to queue (already visited)
Visit 4 ✅
```

Both approaches confirm that a valid path exists between `0` and `4`.

## Complexity Analysis
| Algorithm | Time Complexity | Space Complexity |
|-----------|----------------|------------------|
| DFS       | O(V + E)       | O(V) (recursion stack) |
| BFS       | O(V + E)       | O(V) (queue) |

Where **V** is the number of vertices and **E** is the number of edges.

## Implementation
Check the `ValidPath.java` file for the full implementation using both DFS and BFS.

## Usage
1. **Run the DFS method:**
   ```java
   boolean result = validPathDFS(n, edges, source, destination);
   ```
2. **Run the BFS method:**
   ```java
   boolean result = validPathBFS(n, edges, source, destination);
   ```

## Conclusion
DFS and BFS are both effective in solving the "Valid Path" problem. DFS is useful for exploring deeply connected components, while BFS finds the shortest path in terms of number of edges.

