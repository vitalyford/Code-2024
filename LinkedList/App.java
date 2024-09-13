public class App {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        System.out.println(list.get(1000000));
    }
}
