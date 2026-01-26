import java.util.*;

public class MaxProduct
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];

        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        int prefix=1;
        int suffix=1;
        int ans=1;

        for(int i=0;i<n;i++)
        {
            if(prefix==0)
            {
                prefix=1;
            }
            if(suffix==0)
            {
                suffix=1;
            }
            prefix=prefix*arr[i];
            suffix=suffix*arr[n-i-1];
        }
        ans=Math.max(prefix,suffix);
        System.out.println(ans);

    }
}