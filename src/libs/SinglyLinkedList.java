package libs;

public class SinglyLinkedList {
    public Node head = null;
    static class Node {
        public int data;
        Node next;
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public void add(int v) {
        while (head != null) {
            head = head.next;
        }
        head = new Node(v, null);
    }



}
