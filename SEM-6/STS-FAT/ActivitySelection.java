import java.util.*;

public class ActivitySelection
{
    public static void printMaxActivities(int s[],int f[],int n)
    {
        int i,j;
        System.out.println("Following activities are selected:");
        i=0;
        System.out.println(i+" ");
        for(j=1;j<n;j++)
        {
            if(s[j]>=f[j])
            {
                System.out.println(j+" ");
                i=j;
            }
        }
    }
    public static void main(String[] args)
    {
        int s[]={1,3,0,5,8,5};
        int f[]={2,4,6,7,8,9};
        int n=s.length;
        printMaxActivities(s, f, n);
    }
}