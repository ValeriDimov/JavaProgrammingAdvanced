package SetsAndMapsAdvanced.Exercises;

import com.sun.source.doctree.SeeTree;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class T02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int firstSetLength = Integer.parseInt(input[0]);
        int secondSetLength = Integer.parseInt(input[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetLength; i++) {
            int setElements = Integer.parseInt(scanner.nextLine());
            firstSet.add(setElements);
        }
        for (int i = 0; i < secondSetLength; i++) {
            int setElements = Integer.parseInt(scanner.nextLine());
            secondSet.add(setElements);
        }
        firstSet.retainAll(secondSet);
        firstSet.forEach(el -> {
            System.out.print(el + " ");
        });
    }
}
