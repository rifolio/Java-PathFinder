# Danish Towns Distance Graph

This Java program reads a file containing distances between Danish towns, constructs a bidirectional graph, checks if the graph is connected, and implements Dijkstra's algorithm to find the shortest path between two towns.

## Task Description

### Part 1: Reading and Constructing Graph
- Read a file named "distDK.txt" containing distances between Danish towns.
- Each line in the file represents a distance between two towns in a comma-separated format: `town1, town2, distance_in_100_meters`.
- Construct a bidirectional graph representing the connections between towns using an adjacency list.

### Part 2: Checking Graph Connectivity
- Implement an algorithm to check whether the graph is connected.
- Ensure that from any node, it's possible to reach all other nodes directly or indirectly.
- Analyze the complexity of the algorithm.

### Part 3: Dijkstra's Algorithm for Shortest Path
- Implement Dijkstra's algorithm to find the shortest path in the graph.
- Use the algorithm to find the shortest path from "Helsingør" to "København" in the constructed graph.

## Code Overview

- `Graph` class: Initializes a bidirectional graph represented by an adjacency list.
- `addRoad(String from, String to, int distance)`: Adds an undirected edge between two towns with a given distance.
- `isConnected()`: Checks if the graph is connected.
- `printMap()`: Prints the adjacency list representation of the graph.
- `dijkstraShortestPath(String source)`: Finds the shortest path using Dijkstra's algorithm from a specified source town to all other towns.
- `getIndex(String node)`: Helper method to get the index of a node in the distance array.
- `getNode(int index)`: Helper method to get the node name from its index in the distance array.
- `Main` class:
    - `main(String[] args)`: Entry point of the program, checks graph connectivity and finds the shortest path using Dijkstra's algorithm.
    - `readDistances(String filename)`: Reads distances from the file and constructs the graph.

## Authors
- Kacper Leon Puzniak
- Salar Komeyshi
- Vlad Horbatenko
