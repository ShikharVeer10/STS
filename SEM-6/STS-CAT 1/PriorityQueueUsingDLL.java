import java.util.*;

class Node {
    int data;
    int priority;
    Node prev, next;

    Node(int d, int p) {
        data = d;
        priority = p;
        prev = next = null;
    }
}
class Prior {
    static Node head = null;

    public static void push(int d, int priority) {
        Node node = new Node(d, priority);

        if (head == null) {
            head = node;
            return;
        }

        Node temp = head, parent = null;

        while (temp != null && temp.priority <= priority) {
            parent = temp;
            temp = temp.next;
        }

        // Insert at beginning
        if (parent == null) {
            node.next = head;
            head.prev = node;
            head = node;
        }
        // Insert at end
        else if (temp == null) {
            parent.next = node;
            node.prev = parent;
        }
        // Insert in middle
        else {
            parent.next = node;
            node.prev = parent;
            node.next = temp;
            temp.prev = node;
        }
    }

    static int peek() {
        return (head != null) ? head.data : -1;
    }

    static int pop() {
        if (head == null)
            return -1;

        int value = head.data;
        head = head.next;

        if (head != null)
            head.prev = null;
        return value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            int pri = sc.nextInt();
            push(data, pri);
        }

        System.out.println(peek());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(peek());

        sc.close();
    }
}
