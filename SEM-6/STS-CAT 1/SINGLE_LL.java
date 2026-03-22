import java.util.*;
class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}
public class SINGLE_LL{
    static Node head;
    static void insert_beg(int val){
        Node newnode=new Node(val);
        if(head==null){ 
            head=newnode; 
            return;
        }
        else{
            newnode.next=head;
            head=newnode;
        }
    }
    static void insert_end(int val){
        Node newnode=new Node(val);
        if(head==null){
            head=newnode;
            return;
        }
        else{
            Node temp=head;
            while (temp.next!=null) {
                temp=temp.next;
            }
            temp.next=newnode;
        }
    }
    static void display(){
        if(head==null){
            return;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                System.out.println(temp.data);
                temp=temp.next;
            }
            System.out.println(temp.data);
        }
    }
    static void insert_pos(int val,int target){
        Node newnode=new Node(val);
        if(head==null){
            head=newnode;
        }else{
            int i=0;
            Node temp=head;
            while(i!=target){
                temp=temp.next;
                i++;
            }
            newnode=temp.next;
            temp.next=newnode;
        }
    }
    public static void main(String[] args) {
        insert_beg(45);
        insert_beg(23);
        insert_beg(241);
        insert_end(563);
        insert_pos(69,2);
        display();
    }
}