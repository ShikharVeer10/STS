import java.util.*;

public class JosephusTrap
{
    // static int josh(int n,int k)
    // {
    //     int pos = 0;
    //     for(int i = 2;i<=n;i++){
    //         pos = (pos+k) % i;
    //     }
    //     return pos + 1;
    // }

    static int josh(int n,int k)
    {
        if(n==1)
        {
            return 1;
        }
        return (josh(n-1,k)+k-1)%n+1;
    }
    public static void main(String[] args) {
        System.out.println(josh(4,3));
    }
}