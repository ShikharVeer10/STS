import java.util.*;
class Main{
    static ArrayList<Integer>[] g;
    static int v;
    static void add(int a,int b){
        g[a].add(b);
        g[b].add(a);
    }
    static void show(){
        for(int i=0;i<v;i++){
            System.out.println(i + " : ");
            for(int x:g[i]){
                System.out.println(x + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        g=new ArrayList[v];
        for(int i=0;i<v;i++){
            g[i]=new ArrayList<>();
        }
        int e=sc.nextInt();
        for(int i=0;i<e;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            add(x,y);
        }
        show();
    }
}