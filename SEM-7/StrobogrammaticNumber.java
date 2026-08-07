import java.util.*;
public class StrobogrammaticNumber{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int l=0,r=s.length()-1;
        while(l<=r){
            char a=s.charAt(l);
            char b=s.charAt(r);
            if(a=='1' && b=='1') ||(a=='0' && b=='0') || (a=='8' && b=='8') || (a=='6' && b=='6') || (a=='9' && b=='9'){
                l++;
                r--;
            }
            else{
                p=false;
                break;
            }
        }
        if(p){
            System.out.println("True");
        }else{
            System.out.println("No");
        }
    }
}