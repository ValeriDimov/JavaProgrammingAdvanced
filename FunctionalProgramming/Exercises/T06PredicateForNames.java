package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class T06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String[] namesArr = scanner.nextLine().split("\\s+");

        Predicate<String> isLessLength = name -> name.length() <= length;
        Arrays.stream(namesArr)
                .filter(isLessLength)
                .forEach(System.out::println);
    }
}
