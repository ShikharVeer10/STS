import java.util.*;
public class TopologicalSort {
    static int nVertices, nEdges;
    static int[][] matrix;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nVertices = sc.nextInt();
        nEdges = sc.nextInt();
        visited = new boolean[nVertices];
        matrix = new int[nVertices][nVertices];
        graph = new ArrayList[nVertices];
        for(int i = 0; i < nVertices; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < nEdges; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            matrix[src][dest] = 1;
            graph[src].add(dest); 
        }
        for(int i = 0; i < nVertices; i++) {
            for(int j = 0; j < nVertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        for(int i = 0; i < nVertices; i++) {
            System.out.print("vertex " + i + " : ");
            for(int ele : graph[i]) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
        for(int i = 0; i < nVertices; i++) {
            if(!visited[i])
                dfs(i);
        }
        System.out.println("Topological sort:");
        while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }
    static void dfs(int v) {
        visited[v] = true;
        for(int neighbour : graph[v]) {
            if(!visited[neighbour])
                dfs(neighbour);
        }
        stack.push(v);
    }
}