# Distance Between Danishc Towns. Portfolio 3
### Computer Science | Software Development
#### Spring Semester 2024

---

## Group members:
- Vladyslav Horbatenko
- Salar Komeyshi
- Kacper Leon Puzniak

---

## 1. Read the file of the current route network and represent it as a graph

Our code consists of two main components: the `Graph` class, responsible for managing the graph data structure, and the `Q1` class, which serves as the entry point and handles file reading and graph printing.

**Graph Class:**
- The Graph class encompasses the methods responsible for managing the graph data structure.
- It initializes the hashmap we call `cityMap` which stores city names as keys and maps of neighboring cities along with distances as values.
- The `addRoad` method then takes care of adding an undirected edge between two cities along with the distance. It does so both way to ensure the bidirectional connection.
- Lastly, the `printMap` method iterates through the `cityMap` hashmap and prints each city with its neighboring cities and their corresponding distances.

**The Q1 Class(Main Class):**
- The main method reads the distances between cities from the source file and creates a `Graph` object representing the road map and then printing.
- The `readDistances` method takes care of reading distances between pairs of cities using scanner to read lines from the source file. At the end, it calls the `addRoad` method of the `Graph` class to add each road to the hashmap.

In summary, the code successfully creates a bidirectional adjacency list graph, representing a road map based on the distances provided in the `distDK.txt` file.

---

## 2. Is the graph connected

To verify that we can proceed with the pathfinding algorithm, first we need to check whether the graph is interconnected, meaning that from a node you can reach all other nodes directly or indirectly. For this purpose, we have `isConnected()` method. This method returns `true` if the graph is connected and `false` otherwise.

### `isConnected()` Explanation
- The `isConnected()` method uses Breadth-First Search (BFS) to explore the graph from a starting node.
- It initializes a set called `visited` to keep track of visited nodes and a queue called `queue` to perform BFS.
- It starts by picking the first city from the map and adds it to the queue.
- In the while loop, it dequeues a city from the queue, marks it as visited, and enqueues its neighbors that have not been visited yet.
- The method continues until there are no more nodes in the queue to explore.
- Finally, it checks if all nodes in the graph have been visited by comparing the size of the `visited` set with the size of the `cityMap`. If they are equal, it means all nodes have been visited and returns `true`, otherwise, it returns `false`.

This method efficiently determines whether the graph is connected, which is a crucial step before performing pathfinding algorithms like Dijkstra's algorithm.

---

## 3. Dijkstra's Algorithm for Finding Shortest Paths

To find the shortest path from Helsingør to Esbjerg, or any other two cities, we use Dijkstra's algorithm. It is a widely used algorithm for finding the shortest path between nodes in a graph.

In our program, we have one main method for Dijkstra and two helper methods. Main method is `dijkstraShortestPath()`, it takes `String source` as an input and a starting node for path finding. As an output we have `Map<String, Integer>`, which is a map containing the shortest distances from the source node to all other nodes in the graph.

Two helper methods: `getIndex()` and `getNode()` speak for themselves. One return index of a node and second returns name of the node.

### Algorithm Explanation
- Dijkstra's algorithm has an array (`dist`) to store the shortest distance from the source node to each node in the graph.
- Initially, all distances are set to infinity, except for the source node, which is set to 0.
- The algorithm iterates until all nodes have been visited.
- In each iteration, it selects the closest unvisited node (the one with the smallest distance) and marks it as visited, also updating list with visited nodes.
- It then updates the distances of the unvisited neighbors of the current node if a shorter path is found through it.
- The process continues until all nodes have been visited and their shortest distances have been determined.
- Finally, it converts the distance array back to a map and returns it, containing the shortest distances from the source node to all other nodes.

---

## 4. Efficiency with priority queue

Using a priority queue makes Dijkstra's algorithm faster because it helps us quickly find the node with the shortest unknown distance from the source node in each step, where nodes represent cities in our road network graph. Here's why it speeds things up:

- **Optimal Node Selection:**
  Dijkstra's algorithm involves the iterative selection of the node with the smallest tentative distance from the source, which hasn't been visited yet. By using a priority queue it allows us for an easy retrieval of this node, Operating at a time complexity of O(log N), where N is the queue's node count. This approach significantly outperforms linear search methods and alternative data structures.
- **Updating Distances:**
  After picking the node with the shortest distance, we adjust the distances of its neighboring nodes if we find a shorter path through it. With a priority queue, this updating process remains efficient, keeping the time complexity at O(log N), where N is the number of nodes in the queue.
- **Decreased Time Complexity:**
  Implementing Dijkstra's algorithm with a priority queue reduces the overall time complexity from O(V^2) to O((V + E) log V), where V is the number of vertices and E is the number of edges in the graph.
- **Space Efficiency:**
  Although employing a priority queue adds some extra space complexity, it's usually minor compared to the difference in time complexity. Also, The space required for the priority queue is often offset by the time saved, especially for larger graphs.

If the program working correct, we will receive this message in the terminal:

