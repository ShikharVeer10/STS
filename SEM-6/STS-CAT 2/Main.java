import java.util.*;
class Edge{
    int v,w;
    Edge(int v,int w){
        this.v=v;
        this.w=w;
    }
}
public class Main{
    static void dial(ArrayList<Edge>[] g,int V,int s,int W){
        int max=(V)*W;
        int[] d=new int[V];
        Arrays.fill(d,Integer.MAX_VALUE);

        d[s]=0;
        ArrayList<ArrayList<Integer>> b=new ArrayList<>();
        for(int i=0;i<=max;i++){
            b.add(new ArrayList<>());
        }
        b.get(0).add(s);
        for(int i=0;i<=max;i++){
            while(!b.get(i).isEmpty()){
                int u=b.get(i).remove(0);
                if(i>d[u]) continue;
                for(Edge e:g[u]){
                    int v=e.v;
                    int w=e.w;
                    if(d[v]>d[u]+w){
                        d[v]=d[u]+w;
                        b.get(d[v]).add(v);
                    }
                }
            }
        }
        System.out.println("\nShortest Distances:");
        for(int i=0;i<V;i++){
            System.out.println(s+" -> "+i+" = "+d[i]);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter vertices: ");
        int V=sc.nextInt();

        System.out.println("Enter edges:");
        int E=sc.nextInt();

        System.out.println("Enter max edge weight:");
        int W=sc.nextInt();

        ArrayList<Edge>[] g=new ArrayList[V];
        for(int i=0;i<V;i++)
            g[i]=new ArrayList<>();
        System.out.println("Enter edges (u v w):");
        for(int i=0;i<E;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();
            g[u].add(new Edge(v, w));
        }
        System.out.print("Enter Source:");
        int s=sc.nextInt();
        dial(g,V,s,W);        
    }
}