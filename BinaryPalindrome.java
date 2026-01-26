import java.util.*;

public class BinaryPalindrome
{
    public static void main(String[] args)
    {
        int x=9;
        String s=Integer.toBinaryString(x);
        String s1="";

        for(int i=s.length()-1;i>=0;i--)
        {
            s1=s1+s.charAt(i);
        }
        if(s.equals(s1))
        {
            System.out.println("True");
        }
    }
}