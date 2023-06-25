public class HeavyVehicle extends Vehicle{
    private int weight;
    private static final String engineType="diesel";

    public HeavyVehicle(String modelNumber, String enginePower, int tireSize, int weight) {
        super(modelNumber, engineType, enginePower, tireSize);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HeavyVehicle{" +super.toString() +
                ", weight=" + weight +
                ", engineType='" + engineType + '\'' +
                '}';
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String getEngineType() {
        return engineType;
    }
}
