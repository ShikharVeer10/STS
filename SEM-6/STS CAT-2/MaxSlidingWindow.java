import java.util.*;
public class MaxSlidingWindow{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter number of elements");
        System.out.println("Enter elements");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();        
        }
        System.out.println("Enter window size (k):");
        int k=sc.nextInt();
        Deque<Integer> dq=new ArrayDeque<>();
        System.out.println("Maximum of each elements");
        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.peekFirst()==i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()]<arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                System.out.println(arr[dq.peekFirst()] + " ");
            }
        }
        sc.close();
   }
}