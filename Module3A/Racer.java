public abstract class Racer {
    protected String name;
    protected double distanceCoveredInMeters;
    protected double minSpeedInMetersPerSecond;
    protected double maxSpeedInMetersPerSecond;

    public Racer(String name, double minSpeedInMetersPerSecond, double maxSpeedInMetersPerSecond) {
        this.name = name;
        this.minSpeedInMetersPerSecond = minSpeedInMetersPerSecond;
        this.maxSpeedInMetersPerSecond = maxSpeedInMetersPerSecond;
        this.distanceCoveredInMeters = 0.0;
    }

    public double getDistanceCoveredInMeters() {
        return distanceCoveredInMeters;
    }

    public abstract void run(double timeIntervalInSeconds);

    @Override
    public String toString() {
        return "Racer {name: " + name + "}";
    }
}