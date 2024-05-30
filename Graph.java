import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// AS asked i have used edge list another format for graph representation and storage
public class Graph {
    private int numVertices; // Number of vertices in the graph
    private LinkedList<Integer>[] adjacencyList; // Adjacency list representation
    private List<int[]> edgeList; // Edge list representation

    // Method to print the edge list
    public void displayEdgeList() {
        System.out.println("Edge List:");
        for (int[] edge : edgeList) {
            System.out.println(edge[0] + " - " + edge[1]);
        }
    }
    public Graph(int vertices) {
        this.numVertices = vertices;
        this.adjacencyList = new LinkedList[vertices];
        this.edgeList = new ArrayList<>(); // Using ArrayList to store the edge list
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph
    public void insertEdge(int start, int end) {
        adjacencyList[start].add(end); // Add the edge to the adjacency list
        adjacencyList[end].add(start);
        edgeList.add(new int[]{start, end}); // Add the edge to the edge list
    }

    // Method to print the adjacency list
    public void displayAdjacencyList() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer neighbour : adjacencyList[i]) {
                System.out.print(" -> " + neighbour);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int vertices = 4; // Define the number of vertices
        Graph graph = new Graph(vertices);
        // Adding edges between every pair of vertices
        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                graph.insertEdge(i, j);
            }
        }
        graph.displayAdjacencyList(); // Print the adjacency list representation
        graph.displayEdgeList(); // Print the edge list representation
    }
}
