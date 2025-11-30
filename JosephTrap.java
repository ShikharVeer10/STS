import java.util.*;

public class JosephTrap
{
    static int josh(int n,int k)
    {
        if(n==1)
        {
            return 1;
        }
        return(josh(n-1,k)+k-1)%n+1;
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        System.out.println(josh(n,k));
    }
}