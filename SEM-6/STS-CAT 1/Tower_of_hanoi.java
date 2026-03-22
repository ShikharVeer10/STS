import java.util.Scanner;
import java.util.Stack;
public class Tower_of_hanoi{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of disks: ");
        int numberofdisks=sc.nextInt();
        if(numberofdisks<=0){
            System.out.println("The number of disks must be greater than zero.");
        }
        else{
            System.out.println("The steps to solve the Tower of Hanoi for: " + numberofdisks + " disks are:");
            towerofhanoi(numberofdisks);
        }
    }
    public static void towerofhanoi(int numberofdisks){
        Stack<Integer> source=new Stack<>();
        Stack<Integer> auxillary=new Stack<>();
        Stack<Integer> destination=new Stack<>();
        char s='S',a='A',d='D';
        for(int i=numberofdisks;i>=1;i--){
            source.push(i);
        }
        int totalMoves=(int)Math.pow(2,numberofdisks)-1;
        if(numberofdisks%2==0){
            char temp=d;
            d=a;
            a=temp;
        }
        for(int i=1;i<=totalMoves;i++){
            if(i%3==1)
            {
                moveDisks(source,destination,s,d);
            }
            else if(i%3==2)
            {
                moveDisks(source,auxillary,s,a);
            }
            else if(i%3==0)
            {
                moveDisks(auxillary,destination,a,d);
            }
        }
    }
    static void moveDisks(Stack<Integer> a,Stack<Integer> b,char s,char d){
        if(a.isEmpty()){
            int disk=b.pop();
            System.out.println(" Move disk " + disk + " from " + d + " to " + s);
            a.push(disk);
        }
        else if(b.isEmpty()){
            int disk=a.pop();
            System.out.println(" Move disk " + disk+ " from " + d + " to " + s);
            a.push(disk);
        }
        else{
            int disk=a.pop();
            System.out.println(" Move disk " + disk + " from " + s + " to " + d);
            b.push(disk);
        }
    }
}