package libs;

public class Node implements Comparable<Node> {
    public int data;
    public Node next;
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    @Override
    public int compareTo(Node node) {
        if(this != node) return -1;
        return 0;
    }
}
