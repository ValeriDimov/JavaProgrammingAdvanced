package DefiningClasses.Exercises.T04RawData;

public class Engine {
    private String model;
    private int engineSpeed;
    private int enginePower;

    public Engine(String model, int engineSpeed, int enginePower) {
        this.model = model;
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    public String getModel() {
        return model;
    }

    public int getEngineSpeed() {
        return engineSpeed;
    }

    public int getEnginePower() {
        return enginePower;
    }


}
