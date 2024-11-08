import java.util.*;
import java.io.*;

class Profile {
    String name;
    int age;
    String school;

    public Profile(String name, int age, String school) {
        this.name = name;
        this.age = age;
        this.school = school;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + school; 
    }

    @Override
    public boolean equals(Object o) {
        Profile p = (Profile)o;
        return p.age == age && p.name.equals(name) && p.school.equals(school);
    }

    @Override
    public int hashCode() {
        int hash = 11;
        hash = 7 * hash + name.hashCode();
        hash = 7 * hash + age;
        hash = 7 * hash + school.hashCode();
        return hash;
    }
}

public class HashExample {
    public static void main(String[] args) throws FileNotFoundException {
        // HashMap<Profile, String> hm = new HashMap<>();
        // hm.put(new Profile("Simona", 20, "Princeton"), "Simona1");
        // hm.put(new Profile("Simona", 20, "Arcadia"), "Simona1");
        // hm.put(new Profile("Ular", 16, "Arcadia"), "Ular");

        // System.out.println(hm.get(new Profile("Simona", 20, "Princeton")));

        Scanner sc = new Scanner(new File("flights.txt"));
        HashMap<String, ArrayList<String>> hm = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] splitted = line.split(" ");

            String key = splitted[0];
            String val = splitted[1];
            if (!hm.containsKey(key)) {
                hm.put(key, new ArrayList<>());
            }
            ArrayList<String> dst = hm.get(key);
            dst.add(val);
        }

        for (Map.Entry<String, ArrayList<String>> : hm.entrySet()) {
            String key = entry.getKey();
            ArrayList<String> val = entry.getValue();

            System.out.println("Key " + key);
            System.out.println("Value " + val);
        }
    }
}
