import java.util.*;
public class SimpleSieve{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean a[]=new boolean[n+1];
        Arrays.fill(a,true);
        for(int i=1;i*i<=n;i++){
            if(a[i]==true){
                for(int j=i*i;j<=n;j++){
                    a[j]=false;
                }
            }
        }
        for(int i=2;i<=n;i++){
            if(a[i]){
                System.out.println(a[i] + " ");
            }
        }
    }
}