package IteratorsAndComparators.Exercises.T05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();

        while (!input.equals("END")) {
            String[] parameters = input.split("\\s+");
            String name = parameters[0];
            int age = Integer.parseInt(parameters[1]);
            String town = parameters[2];
            Person person = new Person(name, age, town);
            people.add(person);

            input = scanner.nextLine();
        }
        int index = Integer.parseInt(scanner.nextLine());
        Person personToCompare = people.get(index - 1);
        people.remove(index - 1);

        int samePeople = 0;
        int differentPeople = 0;

        for (Person person : people) {
            if (person.compareTo(personToCompare) == 0) {
                samePeople++;
            } else {
                differentPeople++;
            }
        }

        int totalPeople = people.size() + 1;
        if (samePeople == 0) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", ++samePeople, differentPeople, totalPeople);
        }
    }
}
