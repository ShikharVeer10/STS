import java.util.*;
class Node {
    int data;
    Node left, right;
    Node(int d) {
        data = d;
        left = right = null;
    }
}
class Main {
    static Node root;
    static Scanner sc = new Scanner(System.in);
    public static void create(int val) {
        Queue<Node> q = new LinkedList<>();
        root = new Node(val);
        q.offer(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (!sc.hasNextInt()) break;
            int v = sc.nextInt();
            if (v != -1) {
                temp.left = new Node(v);
                q.offer(temp.left);
            }
            if (!sc.hasNextInt()) break;
            v = sc.nextInt();
            if (v != -1) {
                temp.right = new Node(v);
                q.offer(temp.right);
            }
        }
    }
    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void leftview(Node root, List<Integer> l, int level) {
        if (root == null) return;
        if (l.size() == level)
            l.add(root.data);
        leftview(root.left, l, level + 1);
        leftview(root.right, l, level + 1);
    }
    public static void rightview(Node root, List<Integer> l, int level) {
        if (root == null) return;
        if (l.size() == level)
            l.add(root.data);
        rightview(root.right, l, level + 1);
        rightview(root.left, l, level + 1);
    }

    public static void main(String[] args) {
        int ele = sc.nextInt();
        create(ele);
        System.out.println("Inorder:");
        inorder(root);
        List<Integer> left = new ArrayList<>();
        leftview(root, left, 0);
        System.out.println("\nLeft View:");
        for (int x : left)
            System.out.print(x + " ");
        List<Integer> right = new ArrayList<>();
        rightview(root, right, 0);
        System.out.println("\nRight View:");
        for (int x : right)
            System.out.print(x + " ");
    }
}