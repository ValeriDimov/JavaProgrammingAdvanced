package IteratorsAndComparators.Exercises.T04Froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numsList = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        Lake lake = new Lake(numsList);

        List<String> output = new ArrayList<>();
        for(Integer stone : lake){
            output.add(String.valueOf(stone));
        }

        System.out.println(String.join(", ", output));
    }
}
