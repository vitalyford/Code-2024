
public class Node {
    Object item; // field
    Node next; // the arraw or the pointer to another cell

    public Node() {
        
    }

    public Node(Object item, Node next) {
        this.item = item;
        this.next = next;
    }

    public Node(Object item) {
        this.item = item;
    }
}