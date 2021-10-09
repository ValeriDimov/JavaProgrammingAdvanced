package DefiningClasses.Exercises.T04RawData;

import java.util.List;

public class Tire {
    private String model;
    private double tirePressure;
    private int tireAge;

    public Tire(String model, double tirePressure, int tireAge) {
        this.model = model;
        this.tirePressure = tirePressure;
        this.tireAge = tireAge;
    }

    public String getModel() {
        return this.model;
    }

    public double getTirePressure() {
        return tirePressure;
    }

    public int getTireAge() {
        return tireAge;
    }

    @Override
    public String toString() {
        return this.model;
    }


}
