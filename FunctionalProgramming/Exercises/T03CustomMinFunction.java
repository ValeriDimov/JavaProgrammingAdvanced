package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class T03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersArr = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        Function<List<Integer>, Integer> getMinNumber = list -> Collections.min(list);

        System.out.println(getMinNumber.apply(numbersArr));

    }
}
