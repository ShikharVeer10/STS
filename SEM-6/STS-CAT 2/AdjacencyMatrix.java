import java.util.*;
public class AdjacencyMatrix {
    static int[][] g;
    static int v;
    static void add(int a,int b){
        g[a][b]=1;
        g[b][a]=1;
    }
    static void show(){
        System.out.println("Adjacency Matrix:");
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                System.out.println(g[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        v=sc.nextInt();
        g=new int[v][v];
        int e=sc.nextInt();
        for(int i=0;i<e;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            add(x,y);
        }
        show();
    }
}
