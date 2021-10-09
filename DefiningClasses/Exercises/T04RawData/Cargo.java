package DefiningClasses.Exercises.T04RawData;

public class Cargo {
    private String model;
    private  int cargoWeight;
    private String cargoType;

    public Cargo(String model, int cargoWeight, String cargoType) {
        this.model = model;
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public String getModel() {
        return model;
    }

    public int getCargoWeight() {
        return cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }

    @Override
    public String toString() {
        return this.model;
    }
}
