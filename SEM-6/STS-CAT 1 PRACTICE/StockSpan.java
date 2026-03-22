import java.util.ArrayList;
import java.util.*;
public class StockSpan{
    static ArrayList<Integer> calculateSpan(int[] arr){
        int n=arr.length;
        ArrayList<Integer> span=new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<n;i++){
            // Pop elements while stack is not empty and top element is smaller than current
            while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                stack.pop();
            }
            // If stack is empty, all elements to the left are smaller
            // Otherwise, span is difference between current index and index at top of stack
            span.add(stack.isEmpty() ? i+1 : i-stack.peek());
            stack.push(i);
        }
        return span;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        ArrayList<Integer> span=calculateSpan(arr);
        for(int x:span){
            System.out.println(x+" ");
        }
    }
}