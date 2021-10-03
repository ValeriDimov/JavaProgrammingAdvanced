package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class T09ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        BiFunction<List<Integer>, Integer, Boolean> isDivisible = ((list, number) -> {
            for (int numberInList : list) {
                if (number % numberInList != 0) {
                    return false;
                }
            }
            return true;
        });

        for (int number = 1; number <= n; number++) {
            if (isDivisible.apply(numbersList, number)) {
                System.out.print(number + " ");
            }
        }
    }
}
