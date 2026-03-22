import java.util.*;
public class SortWithoutExtraSpace{
    public static void main(String[] args){
        Queue<Integer> q=new LinkedList<>();
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            q.offer(sc.nextInt());
        }
        sort(q);
        System.out.println(q);
    }
    static void sort(Queue<Integer> q){
        int n=q.size();
        for(int i=0;i<n;i++){
            int mi=-1;
            int mv=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                int cv=q.poll();
                if(cv<mv&&j<n-i){
                    mv=cv;
                    mi=j;
                }
                q.offer(cv);
            }
            for(int k=0;k<n;k++){
                int v=q.poll();
                if(k!=mi){
                    q.offer(v);
                }
            }
            q.offer(mv);
        }
    }
}