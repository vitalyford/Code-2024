import java.util.*;

class Human implements Comparable<Human> {
    String firstName;
    String lastName;
    int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int compareTo(Object o) {
        return this.firstName.compareTo(((String)o).firstName)
               + this.lastName.compareTo(((String)o).lastName);
    }
}

public class Sorting {
    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<>();

        humans.add(new Human(null, null, 0));
        humans.add(-345);
        humans.add(230);

        Collections.sort(humans); //, Collections.reverseOrder());

        System.out.println(humans);
    }
}
