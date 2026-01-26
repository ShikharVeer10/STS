import java.util.*;
public class CelebrityProblem{
    static int celebrity(int[][] mat){
        int n=mat.length;
        int[] indegree=new int[n];
        int[] outdegree=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int x=mat[i][j];
                outdegree[i]+=x;
                indegree[j]+=x;
            }
        }
        for(int i=0;i<n;i++){
            if (indegree[i]==n-1 && outdegree[i]==0){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[][] mat={{0,1,0},{0,0,0},{0,1,0}};
        System.out.println(celebrity(mat));
    }
}