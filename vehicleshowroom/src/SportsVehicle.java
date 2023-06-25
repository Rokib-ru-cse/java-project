public class SportsVehicle extends Vehicle{
    private int turbo;
    private static final String engineType = "oil";

    public SportsVehicle(String modelNumber, String enginePower, int tireSize, int turbo) {
        super(modelNumber, engineType, enginePower, tireSize);
        this.turbo = turbo;
    }

    @Override
    public String toString() {
        return  "SportsVehicle { " +super.toString()+
                ", turbo=" + turbo +
                ", engineType='" + engineType + '\'' +
                '}';
    }

    public int getTurbo() {
        return turbo;
    }

    public void setTurbo(int turbo) {
        this.turbo = turbo;
    }

    @Override
    public String getEngineType() {
        return engineType;
    }
}
