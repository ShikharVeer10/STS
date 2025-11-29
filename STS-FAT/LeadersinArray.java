import java.util.*;

public class LeadersinArray
{
    static void findLeaders(int[] arr,int size)
    {
        int rightMax=arr[arr.length-1];
        System.out.println(rightMax+" ");
        for(int i=size-2;i>=0;i--)
        {
            if(arr[i]>rightMax)
            {
                rightMax=arr[i];
                System.out.println(rightMax+" ");
            }
        }
    }
    public static void main(String[] args)
    {
        int[] arr={2,3,4,6,1,0};
        int n=6;
        findLeaders(arr, n);
    }
}