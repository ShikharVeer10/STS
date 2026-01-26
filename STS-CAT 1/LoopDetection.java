import java.util.*;

public class LoopDetection {
    Node head = null;
    class Node {
        int data;
        Node next;
        Node(int n) {
            data = n;
            next = null;
        }
    }
    void insert(int n) {
        Node newNode = new Node(n);
        if (head == null) {
            head = newNode;
        } else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = newNode;
        }
    }
    boolean create(int a, int b) {
        int c = 0;
        Node p1 = head;
        Node p2 = head;
        while (c < a) {
            p1 = p1.next;
            c++;
        }
        c = 0;
        while (c < b) {
            p2 = p2.next;
            c++;
        }
        p2.next = p1;
        return true;
    }
    boolean detect() {
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LoopDetection l = new LoopDetection();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            l.insert(x);
        }
        int a = sc.nextInt();
        int b = n - 1;
        l.create(a, b);
        System.out.println(l.detect());
    }
}
