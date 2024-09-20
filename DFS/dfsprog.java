import java.util.ArrayList;
import java.util.Scanner;

public class GraphDFS {

    private int vertices; 
    private ArrayList<ArrayList<Integer>> adjList; 

    public GraphDFS(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>(vertices);
        
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjList.get(source).add(destination); 
    }

    private void dfsHelper(int vertex, boolean[] visited) {
        visited[vertex] = true; 
        System.out.print(vertex + " ");
       
        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited);
            }
        }
    }

   
    public void dfs(int startVertex) {
        boolean[] visited = new boolean[vertices]; 
        dfsHelper(startVertex, visited); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int v = sc.nextInt();
        GraphDFS graph = new GraphDFS(v);

        
        System.out.println("Enter number of edges:");
        int e = sc.nextInt();

         System.out.println("Enter the edges (source destination):");
        for (int i = 0; i < e; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.println("Enter starting vertex for DFS:");
        int startVertex = sc.nextInt();

        System.out.println("DFS traversal starting from vertex " + startVertex + ":");
        graph.dfs(startVertex);

        sc.close();
    }
}
