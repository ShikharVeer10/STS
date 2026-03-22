import java.util.*;

public class SelectionSort
{
    static void SelectionSort(int[] arr)
{
    int n=arr.length;
    for(int i=0;i<n;i++)
    {
        int minIndex=i;
        for(int j=i+1;j<n;j++)
        {
            if(arr[j]<arr[minIndex])
            {
                minIndex=j;
            }
        }
        int temp=arr[i];
        arr[i]=arr[minIndex];
        arr[minIndex]=temp;
    }
}
public static void main(String[] args)
{
    int[] arr={2,4,3,5,6,1,0};
    for(int x:arr)
    {
        System.out.println(x+" ");
    }
}
}