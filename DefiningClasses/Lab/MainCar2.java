package DefiningClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainCar2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car2> car2List = new ArrayList<>();
        Car2 car2 = null;

        for (int i = 1; i <=n; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            if (inputArr.length == 1) {
                car2 = new Car2(inputArr[0]);
                car2List.add(car2);
            } else {
                car2 = new Car2(inputArr[0], inputArr[1], Integer.parseInt(inputArr[2]));
                car2List.add(car2);
            }
        }
        System.out.println();
        for (Car2 car : car2List) {
            System.out.println(car.toString());
        }
    }
}
