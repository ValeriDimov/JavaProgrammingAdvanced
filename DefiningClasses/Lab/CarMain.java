package DefiningClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Car> carList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            carList.add(new Car(input[0], input[1], Integer.parseInt(input[2])));
        }
        for (Car car : carList) {
            System.out.println(car.carInfo());
        }
    }
}
