public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * This method takes in an object and adds it to the end of the list
     * @param obj is the item we insert to the LinkedList
     *            at the end of the list
     */
    public void add(Object obj) {
        Node n = new Node(obj);
        // Handle the case when there are not items
        // in the list
        if (size == 0) {
            head = n;
            tail = n;
        }
        else {
            // tail++;
            tail.next = n;
            tail = n;
        }
        size++;
    }

    public Object get(int index) {
        Node curr = head;
        if (index < 0 || index >= size) {
            index = Math.floorMod(index, size);
        }
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return curr.item;
            }
            curr = curr.next;
        }
        return null;
    }

    public void add(Object obj, int pos) {

    }

    @Override
    public String toString() {
        String output = "";
        for (Node curr = head; curr != null; curr = curr.next){
            output += curr.item + " ";
        }
        return output;
    }
}
