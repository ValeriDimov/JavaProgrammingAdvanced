package DefiningClasses.Exercises.T07Google;

public class Car {
    private String carModel;
    private String carSpeed;

    public Car(String carModel, String carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarSpeed() {
        return carSpeed;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setCarSpeed(String carSpeed) {
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        if (this.carModel != null) {
            return String.format("%s %s", this.carModel, this.carSpeed);
        } else {
            return "";
        }
    }
}
