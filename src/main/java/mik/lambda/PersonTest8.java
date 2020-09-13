package mik.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PersonTest8 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Russel", "Khan", 32),
                new Person("Aftab", "Uddin", 33),
                new Person("Ratul", "Arefin", 15),
                new Person("Israt", "Jahan", 28),
                new Person("John", "Doe", 50),
                new Person("Jane", "Doe", 43)));
        //sort by first name
        Collections.sort(people, (p1,p2)->{return p1.getFirstName().compareTo(p2.getFirstName());});
        printSpecific(people,p->true, p-> System.out.println(p));
        //print with first name starts with R
        System.out.println("Get user with first name starts with R");
        printSpecific(people, (p)->p.getFirstName().startsWith("R"), p-> System.out.println(p));
        int sum =0;
        System.out.println("********************");
        people.forEach(p -> System.out.println(p.getFirstName()));
        int a = -3 % 3;
        System.out.println(a);
    }
    public static void printSpecific(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
        for (Person p:
             people) {
            if(predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }
}
