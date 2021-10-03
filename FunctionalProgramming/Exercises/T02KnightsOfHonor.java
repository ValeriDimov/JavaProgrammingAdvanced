package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class T02KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> namesList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Consumer<String> addingSirFunction = name -> System.out.println("Sir " + name);

        namesList.forEach(name -> addingSirFunction.accept(name));
    }
}
