public class Vehicle {
    private String modelNumber;
    private String engineType;
    private String enginePower;
    private int tireSize;

    public Vehicle() {
    }

    public Vehicle(String modelNumber, String engineType, String enginePower, int tireSize) {
        this.modelNumber = modelNumber;
        this.engineType = engineType;
        this.enginePower = enginePower;
        this.tireSize = tireSize;
    }

    @Override
    public String toString() {
        return "modelNumber='" + modelNumber + '\'' +
                ", engineType='" + engineType + '\'' +
                ", enginePower='" + enginePower + '\'' +
                ", tireSize=" + tireSize ;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }

    public int getTireSize() {
        return tireSize;
    }

    public void setTireSize(int tireSize) {
        this.tireSize = tireSize;
    }
}
