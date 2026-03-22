import java.util.*;
public class BellmanFord{
    static class E{
        int u, v, w;
        E(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    static void bf(int n, ArrayList<E> l, int s) {
        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[s] = 0;
        for (int i = 1; i < n; i++) {
            for (E e : l) {
                if (d[e.u] != Integer.MAX_VALUE && d[e.u] + e.w < d[e.v]) {
                    d[e.v] = d[e.u] + e.w;
                }
            }
        }
        for (E e : l) {
            if (d[e.u] != Integer.MAX_VALUE && d[e.u] + e.w < d[e.v]) {
                System.out.println("Negative cycle detected");
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + (d[i] == Integer.MAX_VALUE ? "INF" : d[i]));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // vertices
        int m = sc.nextInt(); // edges
        ArrayList<E> l = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            l.add(new E(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        int source = sc.nextInt();
        bf(n, l, source);
        sc.close();
    }
}