import java.util.*;
class Edge{
    int v, w;
    Edge(int v, int w) { this.v = v; this.w = w; }
}
public class DialAlgorithm{
    static void dial(List<Edge>[] g, int V, int s, int W) {
        int[] d = new int[V];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[s] = 0;
        List<List<Integer>> b = new ArrayList<>();
        for (int i = 0; i <= V * W; i++) b.add(new ArrayList<>());
        b.get(0).add(s);
        for (int i = 0; i < b.size(); i++)
            while (!b.get(i).isEmpty()) {
                int u = b.get(i).remove(0);
                if (i > d[u]) continue;
                for (Edge e : g[u])
                    if (d[u] + e.w < d[e.v]) {
                        d[e.v] = d[u] + e.w;
                        b.get(d[e.v]).add(e.v);
                    }
            }
        for (int i = 0; i < V; i++)
            System.out.println(s + " -> " + i + " = " + d[i]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt(), W = sc.nextInt();
        List<Edge>[] g = new ArrayList[V];
        for (int i = 0; i < V; i++) g[i] = new ArrayList<>();
        while (E-- > 0)
            g[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
        dial(g, V, sc.nextInt(), W);
    }
}