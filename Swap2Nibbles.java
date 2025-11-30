import java.util.*;
public class Swap2Nibbles
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int swapnum=((num&0x0F)<<4|(num&0xF0)>>4);
        System.out.println(swapnum);
    }
}