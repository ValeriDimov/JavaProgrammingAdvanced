package DefiningClasses.Exercises.T04RawData;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<Car> cars = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);

            List<Tire> tireList = new ArrayList<>();
            Tire tire1 = new Tire(model, tire1Pressure, tire1Age);
            tireList.add(tire1);
            Tire tire2 = new Tire(model, tire2Pressure, tire2Age);
            tireList.add(tire2);
            Tire tire3 = new Tire(model, tire3Pressure, tire3Age);
            tireList.add(tire3);
            Tire tire4 = new Tire(model, tire4Pressure, tire4Age);
            tireList.add(tire4);

            Cargo cargo = new Cargo(model, cargoWeight, cargoType);
            Engine engine = new Engine(model, engineSpeed, enginePower);
            Car car = new Car(model, engine, cargo, tireList);

            cars.add(car);
        }

        String command = scanner.nextLine();
        if (command.equals("fragile")) {
            cars
                    .stream()
                    .filter(car -> car.getCargo().getCargoType().equals("fragile"))
                    .forEach(car -> {
                        if (car.getTires().get(1).getTirePressure() < 1) {
                            System.out.println(car.getTires().get(1).getModel());
                        }
                    });

        } else if (command.equals("flamable")) {
            cars
                    .stream()
                    .filter(car -> car.getCargo().getCargoType().equals("flamable"))
                    .filter(car -> car.getEngine().getEnginePower() > 250)
                    .forEach(System.out::println);
        }
    }
}
