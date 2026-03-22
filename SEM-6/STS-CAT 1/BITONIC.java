class Node {
    int data;
    Node prev;
    Node next;
    Node(int d) {
        data = d;
        prev = next = null;
    }
}
class Bitonic {
    static Node head;
    static void insert(int e) {
        Node newnode = new Node(e);
        if (head == null) {
            head = newnode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newnode;
        newnode.prev = temp;
    }
    static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    static void bitonic() {
        if (head == null || head.next == null) return;
        Node front = head;
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        Node result = null, tail = null;
        while (front != null && last != null &&
               front.prev != last && last.next != front) {
            Node pick;
            if (front.data <= last.data) {
                pick = front;
                front = front.next;
            } else {
                pick = last;
                last = last.prev;
            }
            pick.prev = pick.next = null;
            if (result == null) {
                result = tail = pick;
            } else {
                tail.next = pick;
                pick.prev = tail;
                tail = pick;
            }
        }
        if (front == last && front != null) {
            front.prev = front.next = null;
            tail.next = front;
            front.prev = tail;
        }
        head = result;
    }
    public static void main(String[] args) {
        insert(10);
        insert(42);
        insert(50);
        insert(4);
        insert(3);
        insert(0);
        insert(-1);
        System.out.println("Original Bitonic List:");
        display();
        bitonic();
        System.out.println("Sorted List:");
        display();
    }
}
