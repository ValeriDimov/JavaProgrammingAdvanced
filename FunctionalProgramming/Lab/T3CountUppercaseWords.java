package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class T3CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");
        int counter = 0;
        Predicate<String> isUpper = w -> {
            return (Character.isUpperCase(w.charAt(0)));
        };
        for (String word : words) {
            if (Character.isUpperCase(word.charAt(0)))
            counter++;
        }
        System.out.println(counter);
        Arrays.stream(words).filter(isUpper).forEach(System.out::println);
    }
}

