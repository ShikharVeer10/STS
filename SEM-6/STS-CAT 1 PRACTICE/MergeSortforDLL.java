import java.util.*;
class MergeSortforDLL{
    static class Node{
        int data;
        Node prev,next;
        Node(int d){
            data=d;
        }
    }
    static Node sort(Node h){
        if(h==null || h.next==null) return h;
        Node mid=split(h);
        return merge(sort(h),sort(mid));
    }
    static Node split(Node h){
        Node slow=h,fast=h;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node mid=slow.next;
        slow.next=null;
        mid.prev=null;
        return mid;
    }
    static Node merge(Node a,Node b){
        if(a==null) return b;
        if(b==null) return a;
        if(a.data<=b.data){
            a.next=merge(a.next,b);
            a.next.prev=a;
            a.prev=null;
            return a;
        }
        else{
            b.next=merge(a,b.next);
            b.next.prev=b;
            b.prev=null;
            return b;
        }
    }
    static void print(Node h){
        while(h!=null){
            System.out.print(h.data+" ");
            h=h.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n=sc.nextInt();
        System.out.print("Enter elements: ");
        Node head=null,tail=null;
        for(int i=0;i<n;i++){
            Node newNode=new Node(sc.nextInt());
            if(head==null){
                head=tail=newNode;
            }else{
                tail.next=newNode;
                newNode.prev=tail;
                tail=newNode;
            }
        }
        System.out.print("Original: ");
        print(head);
        head=sort(head);
        System.out.print("Sorted: ");
        print(head);
        sc.close();
    }
}