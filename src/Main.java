import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
Authors: Kacper Leon Puzniak, Salar Komeyshi, Vlad Horbatenko
In the following Java code we define a class called "Graph" representing an undirected graph with weighted edges,
to then provide methods to add the edges and prints the graph, along with the Main class that reads the distances between towns from the source file,
which then can be used to print the graph/ road map accordingly.
*/


//The graph class initializes the hashmap
class Graph {
    private Map<String, Map<String, Integer>> cityMap;

    public Graph() {
        cityMap = new HashMap<>();
    }

    //This method adds an undirected edge between vertices "from" and "to" with a given distance in a graph represented by an adjacency list
    public void addRoad(String from, String to, int distance) {
        cityMap.computeIfAbsent(from, k -> new HashMap<>()).put(to, distance);
        cityMap.computeIfAbsent(to, k -> new HashMap<>()).put(from, distance); //This line makes sure that it is bidirectional
    }

    //This method iterates through the map of the cities and their connections, printing each city with its neighboring cities and corresponding distances
    public void printMap() {
        for (Map.Entry<String, Map<String, Integer>> cityEntry : cityMap.entrySet()) {
            String city = cityEntry.getKey();
            Map<String, Integer> connections = cityEntry.getValue();
            System.out.print(city + ": ");
            for (Map.Entry<String, Integer> roadEntry : connections.entrySet()) {
                String neighbor = roadEntry.getKey();
                int distance = roadEntry.getValue();
                System.out.print("(" + neighbor + ", " + distance + ") ");
            }
            System.out.println();
        }
    }
}
//The main class takes care of getting the source file and printing the road map
public class Main {
    public static void main(String[] args) {
        String filename = "src/distDK.txt";
        Graph roadMap = readDistances(filename);

        //Print the road map
        roadMap.printMap();
    }
    //The readDistances method uses a while loop to read the distance between city1 and city2 from the source file.
    public static Graph readDistances(String filename) {
        Graph roadMap = new Graph();

        //Reading the file with cities
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String city1 = parts[0];
                String city2 = parts[1];
                int distance = Integer.parseInt(parts[2]);
                roadMap.addRoad(city1, city2, distance); //The class then calls the addRoad method to create a path in the graph
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return roadMap;
    }
}
