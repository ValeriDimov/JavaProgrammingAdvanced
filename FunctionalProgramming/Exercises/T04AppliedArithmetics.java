package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class T04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine()
                .split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());

        String commands = scanner.nextLine();
        Function<List<Integer>, List<Integer>> addFunc = list -> list.stream()
                .map(n -> n += 1).collect(Collectors.toList());
        Function<Integer, Integer> multiplyFunc = num -> num *= 2;
        Function<List<Integer>, List<Integer>> subtractFunc = list -> list
                .stream().map(num -> num -= 1).collect(Collectors.toList());
        Consumer<List<Integer>> printFunc = list -> list.forEach(num -> System.out.print(num + " "));

        while (!commands.equals("end")) {
            switch (commands) {
                case "add":
                numbersList = addFunc.apply(numbersList);
                    break;
                case "multiply":
                    numbersList = numbersList.stream().map(n -> multiplyFunc.apply(n)).collect(Collectors.toList());
                    break;
                case "subtract":
                    numbersList = subtractFunc.apply(numbersList);
                    break;
                case "print":
                    printFunc.accept(numbersList);
                    System.out.println();
                    break;
            }
            commands = scanner.nextLine();
        }
    }
}
