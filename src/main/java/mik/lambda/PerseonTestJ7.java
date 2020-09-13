package mik.lambda;

        import java.util.*;

public class PerseonTestJ7 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Russel", "Khan", 32),
                new Person("Aftab", "Uddin", 33),
                new Person("Israt", "Jahan", 28),
                new Person("John", "Doe", 50),
                new Person("Jane", "Doe", 43)));
        //sort by last name
        Collections.sort(people,
                new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getLastName().compareTo(o2.getLastName());
                    }
                });

        //prin all element on the list
        printAllPeople(people);
        //print by last name starts with D
        System.out.println("Print people with last name starts with D");
        printPeoplewithCondition(people, new Condition() {
            @Override
            public boolean test(Person p) {
                return p.getLastName().startsWith("D");


            }
        });
        System.out.println("Print people with first name starts with R");
        printPeoplewithCondition(people, p->p.getFirstName().startsWith("R"));
    }

    private static void printPeoplewithCondition(List<Person> people, Condition c) {
        for (Person p:
             people) {
            if(c.test(p)){
                System.out.println(p);
            }
        }
    }

    private static void printAllPeople(List<Person> people) {
        for (Person p:
             people) {
            System.out.println(p);
        }
    }
}
interface Condition{
    boolean test(Person p);
}
