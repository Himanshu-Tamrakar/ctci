package libs;

import com.ht.algorithms.Solution2_1;

public class LinkedList {
    Node head;

    public void add(int v) {
        if(head == null) {
            head = new Node(v, null);
            return;
        }
        Node root = head;
        while (root.next != null) {
            root = root.next;
        }
        root.next = new Node(v, null);
    }

    public Node getList() {
        return this.head;
    }


}
