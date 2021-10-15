package Generics.Exercises.T01GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Double> stringBox = new Box<>();

        for (int i = 0; i < n; i++) {
            Double input = Double.parseDouble(scanner.nextLine());
            stringBox.getElements().add(input);
        }
        Double elementToCompare = Double.parseDouble(scanner.nextLine());
       int graterElements =  stringBox.countOfGraterElements(elementToCompare);
        System.out.println(graterElements);
    }
}
