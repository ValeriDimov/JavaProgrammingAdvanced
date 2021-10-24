package IteratorsAndComparators.Exercises.T06StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n  = Integer.parseInt(scanner.nextLine());
        Set<Person> nameCompareSet = new TreeSet<>(new NameComparator());
        Set<Person> ageCompareSet = new TreeSet<>(new AgeComparator());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Person person = new Person(name, age);
            nameCompareSet.add(person);
            ageCompareSet.add(person);
        }
        for (Person person : nameCompareSet) {
            System.out.println(person);
        }

        for (Person person : ageCompareSet) {
            System.out.println(person);
        }
    }
}
