public class NormalVehicle extends Vehicle{

    public NormalVehicle(String modelNumber, String engineType, String enginePower, int tireSize) {
        super(modelNumber, engineType, enginePower, tireSize);
    }

    @Override
    public String toString() {
        return "NormalVehicle{"+super.toString()+"}";
    }

    public NormalVehicle() {
    }
}
