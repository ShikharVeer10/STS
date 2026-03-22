import java.util.*;
import java.util.Scanner;
class Node{
    int data;
    Node left;
    Node right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
class Main{
    static Node root;
    Scanner sc=new Scanner(System.in);
    public static void create(int val){
        Queue<Node> q=new LinkedList<>();
        root=new Node(val);
        q.offer(root);
        int v;
        while(!q.isEmpty()){
            Node temp=q.poll();
            v=sc.nextInt();
            if(v!=-1){
                temp.left=new Node(v);
                q.offer(temp.left);
            }
            v=sc.nextInt();
            if(v!=-1){
                temp.right=new Node(v);
                q.offer(temp.right);
            }
        }
    }
    public static void addleftboundary(Node root,List<Integer> res){
        Node curr=root.left;
        while(curr!=null){
            if(!isleaf(curr))
                res.add(curr.data);
            if(curr.left!=null)
                curr=curr.left;
            else
                curr=curr.right;
        }
    }
    public static void addrightboundary(Node root,List<Integer> res){
        List<Integer> temp=new ArrayList<>();
        Node curr=root.right;
        while(curr!=null){
            if(!isleaf(curr))
                temp.add(curr.data);
            if(curr.right!=null)
                curr=curr.right;
            else
                curr=curr.left;
        }
        for(int i=temp.size()-1;i>=0;i--)
            res.add(temp.get(i));
    }
    public static void main(String[] args){
        if(root==null) return;
        if(isleaf(root)) res.add(root.data);
        addleafs(root.left,res);
        addleafs(root.right,res);
    }

    public static boolean isleaf(Node root){
        return (root.left==null && root.right==null);
    }

    public static List<Integer> BoundaryTraversal(Node root){
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;

        res.add(root.data);
        addleftboundary(root, res);
        addleafs(root,res);
        addrightboundary(root, res);
        return res;
    }
    public static void main(String[] args){
        int ele=sc.nextInt();
        create(ele);

        List<Integer> l=new ArrayList<>();
        l=BoundaryTraversal(root);
        System.out.println(l);

    }
}