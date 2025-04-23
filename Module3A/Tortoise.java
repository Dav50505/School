// implement the Tortoise class here
public class Tortoise extends Racer {
    public Tortoise(String name) {
        super(name, 2.0, 3.0);
    }

    @Override
    public void run(double timeIntervalInSeconds) {
        double speed = minSpeedInMetersPerSecond + (Math.random() * (maxSpeedInMetersPerSecond - minSpeedInMetersPerSecond));
        double distanceThisInterval = speed * timeIntervalInSeconds;
        distanceCoveredInMeters += distanceThisInterval;
        System.out.printf("%s walks %.2f meters; now at marker %.2f%n", 
            name, distanceThisInterval, distanceCoveredInMeters);
    }
}