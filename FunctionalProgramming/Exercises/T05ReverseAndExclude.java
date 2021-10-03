package FunctionalProgramming.Exercises;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class T05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> isDivisible = num -> num % n != 0;

        Consumer<List<Integer>> printDivisibleList = list -> list.stream()
                .filter(isDivisible).forEach(num -> System.out.print(num + " "));

        List<Integer> divNums = new ArrayList<>();
        divNums.addAll(numbersList);
        Collections.reverse(divNums);
        printDivisibleList.accept(divNums);
    }
}
