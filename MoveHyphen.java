import java.util.*;
public class MoveHyphen
{
    static void moveFront(char[] str)
    {
        int i=str.length-1;
        for(int j=i;j>=0;j--)
        {
            if(str[j]!='-')
            {
                char c=str[i];
                str[i]=str[j];
                str[j]=c;
                i--;
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String input=sc.nextLine();

        char str[]=input.toCharArray();
        moveFront(str);
        System.out.println(String.valueOf(str));
    }
}