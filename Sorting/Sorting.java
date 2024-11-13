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

    @Override
    public int compareTo(Human h) {
        if (!firstName.equals(h.firstName)) {
            return firstName.compareTo(h.firstName);
        } else if (!lastName.equals(h.lastName)) {
            return lastName.compareTo(h.lastName);
        } else {
            return age - h.age;
        }
    }

    public String toString() {
        return firstName + " " + lastName + " " + age;
    }
}

class CompareByAgeOnly implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.age - h2.age;
    }
}

class CompareByFirstNameOnly implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.firstName.compareTo(h2.firstName);
    }
}

class CompareByLastNameOnly implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.lastName.compareTo(h2.lastName);
    }
}

class CompareByFirstAndLastNameOnly implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        if (!h1.firstName.equals(h2.firstName)) {
            return h1.firstName.compareTo(h2.firstName);
        } else {
            return h1.lastName.compareTo(h2.lastName);
        }
    }
}

class CompareByFirstAndLastNameAndAge implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        if (!h1.firstName.equals(h2.firstName)) {
            return h1.firstName.compareTo(h2.firstName);
        } else if (!h1.lastName.equals(h2.lastName)) {
            return h1.lastName.compareTo(h2.lastName);
        } else {
            return h1.age - h2.age;
        }
    }
}

public class Sorting {
    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<>();
        HashMap<String, Comparator<Human>> comparators = new HashMap<>();
        comparators.put("first name", new CompareByFirstNameOnly());
        comparators.put("last name", new CompareByLastNameOnly());
        comparators.put("first and last name", new CompareByFirstAndLastNameOnly());
        comparators.put("first and last name and age", new CompareByFirstAndLastNameAndAge());

        humans.add(new Human("Chip", "Munk", 233));
        humans.add(new Human("Bara", "Cuda", 26));
        humans.add(new Human("Chip", "Chino", -743));

        
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter the name of the comparator: ");

            String compName = sc.nextLine().toLowerCase();
            if (!comparators.containsKey(compName)) {
                break;
            }

            Collections.sort(humans, comparators.get(compName));// , Collections.reverseOrder());
            // System.out.println(humans);

            PriorityQueue<Human> pq = new PriorityQueue<>(comparators.get(compName));
            pq.offer(new Human("Bara", "Cuda", 26));
            pq.offer(new Human("Chip", "Chino", -743));
            pq.offer(new Human("Chip", "Munk", 233));


            while (!pq.isEmpty()) {
                System.out.println(pq.poll());
            }
        }
    }
}
