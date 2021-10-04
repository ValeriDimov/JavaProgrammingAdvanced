package FunctionalProgramming.Lab;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class T1SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] evenArr = Arrays.stream(numbersArr).filter(n -> n % 2 == 0).toArray();
        int[] sortedArr = Arrays.stream(evenArr).sorted().toArray();

        List<String> sortedInString = new ArrayList<>();
        List<String> evenInString = new ArrayList<>();

        for (int n : sortedArr) {
            sortedInString.add(n + "");
        }
        Arrays.stream(evenArr).forEach(n -> {
            evenInString.add(n +"");
        });
        System.out.println(String.join(", ", evenInString));
        System.out.println(String.join(", ", sortedInString));
    }
}