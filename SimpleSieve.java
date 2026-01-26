import java.util.*;
public class SimpleSieve
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number:");
        int num=sc.nextInt();

        boolean[] bool=new boolean[num];
        for(int i=0;i<num;i++)
        {
            bool[i]=true;
        }

        for(int i=2;i<Math.sqrt(num);i++)
        {
            for(int j=(i*i);j<num;j++)
            {
                bool[j]=false;
            }
        }
        System.out.println("List of prime numbers upto given number are:");
        for(int i=2;i<bool.length;i++)
        {
            if(bool[i]==true)
            {
                System.out.println(i);
            }
        }
    } 

}