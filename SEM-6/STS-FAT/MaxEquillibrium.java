import java.io.*;
import java.util.*;

public class MaxEquillibrium
{
    static int findMaxSum(int[] arr,int n)
    {
        int[] presum=new int[n];
        int[] suffsum=new int[n];
        int ans=Integer.MIN_VALUE;

        presum[0]=arr[0];
        for(int i=1;i<n;i++)
        {
            presum[i]=presum[i-1]+arr[i];
        }
        suffsum[n-1]=arr[n-1];
        if(presum[n-1]==suffsum[n-1])
        {
            ans=Math.max(ans,presum[n-1]);
        }

        for(int i=n-2;i>=0;i--)
        {
            suffsum[i]=suffsum[i+1]+arr[i];
            if(suffsum[i]==presum[i])
            {
                ans=Math.max(ans,presum[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(findMaxSum(arr, n));
    }
}