package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class T2SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
//        List<Integer>numbersList = Arrays.stream(scanner.nextLine().split(", "))
//                .map(Integer::parseInt).collect(Collectors.toList());
        Function<int[], Long> giveCount = array -> Arrays.stream(array).count();
        Function<int[], Integer> giveSum = array -> Arrays.stream(array).sum();

        System.out.println("Count = " + giveCount.apply(numbersArr));
        System.out.println("Sum = " + giveSum.apply(numbersArr));

    }
}
