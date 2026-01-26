import java.util.*;
public class RemainderTheorem
{
    static int findMinx(int num[],int rem[],int k)
    {
        int x=1;
        while(true)
        {
            int j;
            for(j=0;j<k;j++)
            {
                if(x%num[j]!=rem[j])
                {
                    return x;
                }
                x++;
            }
        }
    }
        public static void main(String[] args)
        {
            int num[]={2,3,5};
            int rem[]={1,2,3};
            int k=num.length;
            System.out.println("x is: "+findMinx(num, rem, k));
        }
    
}