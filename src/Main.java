import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
Authors: Kacper Leon Puzniak, Salar Komeyshi, Vlad Horbatenko
*/


//The graph class initializes the hashmap
class Graph {
    private final Map<String, Map<String, Integer>> cityMap;

    public Graph() {
        cityMap = new HashMap<>();
    }

    //This method adds an undirected edge between vertices "from" and "to" with a given distance in a graph represented by an adjacency list
    public void addRoad(String from, String to, int distance) {
        cityMap.computeIfAbsent(from, k -> new HashMap<>()).put(to, distance);
        cityMap.computeIfAbsent(to, k -> new HashMap<>()).put(from, distance); //This line makes sure that it is bidirectional
    }


    //In this method we check if all nodes in our adjacency list and that they all can reach every other city/node in the file directly or indirectly.
    public boolean isConnected() {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        //This code picks the first city from the list and puts it into the queue to start the process.
        String startNode = cityMap.keySet().iterator().next();
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            visited.add(current);
            for (String neighbor : cityMap.get(current).keySet()) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                }
            }
        }

        //Check if all nodes have been visited
        return visited.size() == cityMap.size();
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
        String filename = "distDK.txt";
        Graph roadMap = readDistances(filename);


//        roadMap.printMap();  //Print the road map

        //Simple boolean checking if the roadMap is connected
        boolean isConnected = roadMap.isConnected();
        if (isConnected) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
        }
    }

    //The readDistances method uses a while loop to read the distance between city1 and city2 from the source file.
    public static Graph readDistances(String filename) {
        Graph roadMap = new Graph();

        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String city1 = parts[0];
                String city2 = parts[1];
                int distance = Integer.parseInt(parts[2]);
                roadMap.addRoad(city1, city2, distance);//The class calls the addRoad method to create a path in the graph
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return roadMap;
    }
}

