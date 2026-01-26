class Node {
    int data;
    Node prev;
    Node next;

    Node(int d) {
        data = d;
        prev = next = null;
    }
}
class BITONIC {
    static Node head;
    static void insert(int e) {
        Node newnode = new Node(e);
        if (head == null) {
            head = newnode;
            return;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            newnode.prev = temp;
            temp.next = newnode;
        }
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
        Node result = null, tail = null;
        while (last.next != null) {
            last = last.next;
        }
        while (front != last) { 
            Node newnode;
            if (front.data <= last.data) {
                newnode = new Node(front.data);
                front = front.next;
            } else {
                newnode = new Node(last.data);
                last = last.prev;
            }
            if (result == null) {
                result = tail = newnode;
            } else {
                tail.next = newnode;
                newnode.prev = tail;
                tail = newnode;
            }
            if (front.prev == last) break; 
        }
        if (front == last) {
            Node newnode = new Node(front.data);
            if (result == null) result = newnode;
            else {
                tail.next = newnode;
                newnode.prev = tail;
            }
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