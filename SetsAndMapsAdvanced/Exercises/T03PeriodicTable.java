package SetsAndMapsAdvanced.Exercises;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class T03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> compounds = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] inputs = scanner.nextLine().split("\\s+");
            Collections.addAll(compounds, inputs);
        }
        System.out.println(String.join(" ", compounds));
    }
}
