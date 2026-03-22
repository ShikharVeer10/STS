import java.util.*;
public class BFSGraph{
    static ArrayList<Integer>[] g;
    static boolean[] vis;
    static int v;
    static void add(int a,int b){
        g[a].add(b);
        g[b].add(a);
    }
    static void bfs(int s){
        Queue<Integer> q=new LinkedList<>();
        vis[s]=true;
        q.add(s);
        while(!q.isEmpty()){
            int x=q.poll();
            System.out.print(x + " ");
            for(int i=0;i<g[x].size();i++){
                int y=g[x].get(i);
                if(!vis[y]){
                    vis[y]=true;
                    q.add(y);
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        v=sc.nextInt();
        g=new ArrayList[v];
        vis=new boolean[v];
        for(int i=0;i<v;i++){
            g[i]=new ArrayList<>();
        }
        int e=sc.nextInt();
        for(int i=0;i<e;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            add(x,y);
        }
        int s=sc.nextInt();
        bfs(s);
    }
}