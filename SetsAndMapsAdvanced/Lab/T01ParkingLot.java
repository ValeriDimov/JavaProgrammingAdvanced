package SetsAndMapsAdvanced.Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class T01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> carNumbers = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] actionAndCar = input.split(", ");
            String action = actionAndCar[0];
            String carNum = actionAndCar[1];

            if (action.equals("IN")) {
                carNumbers.add(carNum);
            } else {
                carNumbers.remove(carNum);
            }
            input = scanner.nextLine();
        }
        String output = carNumbers.isEmpty()
                ? "Parking Lot is Empty" :
                String.join(System.lineSeparator(), carNumbers);
        System.out.println(output);
    }
}
