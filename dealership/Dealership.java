package dealership;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getManufacturer().equals(manufacturer) && data.get(i).getModel().equals(model)) {
                data.remove(data.get(i));
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        if (data.isEmpty()) {
            return null;
        } else {
            return data.stream().max((c1, c2) -> Integer.compare(c1.getYear(), c2.getYear())).get();
        }
    }

    public Car getCar(String manufacturer, String model) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getManufacturer().equals(manufacturer) && data.get(i).getModel().equals(model)) {
                return data.get(i);
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are in a car dealership ").append(this.name).append(":").append(System.lineSeparator());
        data.forEach(c -> sb.append(c.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
