import java.util.*;

class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
class Main{
    static Node root;
    static Node prev=null,first=null,second=null;
    public static void create(String a[]){
        if(a.length==0 || a[0].equals("N")) return;
        root=new Node(Integer.parseInt(a[0]));
        Queue<Node> q =new LinkedList<>();
        q.add(root);
        int i=1;
        while(!q.isEmpty()){
            Node temp=q.poll();
            if(i<a.length && !a[i].equals("N")){
                temp.left=new Node(Integer.parseInt(a[i]));
                q.add(temp.left);
            }
            i++;
            if(i<a.length && !a[i].equals("N")){
                temp.right=new Node(Integer.parseInt(a[i]));
                q.add(temp.right);
            }
            i++;
        }
    }
    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        if(prev!=null && root.data<prev.data){
            if(first==null){
                first=prev;
                second=root;
            }
            prev=root;
            inorder(root.right);
        }
    }
    public static Node recovertree()
    {
        if(root==null){
            return null;
        inorder(root);
        if(first!=null && second!=null){
            int temp=first.data;
            first.data=second.data;
            second.data=temp;
        }
    }
    return root;
    
        public static void display(Node root){
        if(root==null) return;
        display(root.left);
        System.out.println(root.data+" ");
        display(root.right);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String a[]=s.split(" ");
        create(a);
        display(root);
        System.out.println();
        root=recovertree();
        display(root);
    }
}
