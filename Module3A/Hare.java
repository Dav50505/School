public class Hare extends Racer {
    private double arrogance;

    public Hare(String name, double arrogance) {
        super(name, 10.0, 15.0); // min speed 10 m/s, max speed 15 m/s for Hare
        this.arrogance = arrogance;
    }

    @Override
    public void run(double timeIntervalInSeconds) {
        // Determine if Hare will nap based on arrogance
        if (Math.random() < arrogance) {
            System.out.printf("%s takes a nap%n", name);
            return;
        }

        // Calculate random speed between min and max
        double speed = minSpeedInMetersPerSecond + (Math.random() * (maxSpeedInMetersPerSecond - minSpeedInMetersPerSecond));
        
        // Calculate distance covered in this interval
        double distanceThisInterval = speed * timeIntervalInSeconds;
        
        // Update total distance
        distanceCoveredInMeters += distanceThisInterval;
        
        // Print formatted message with 2 decimal places
        System.out.printf("%s hops %.2f meters; now at marker %.2f%n", 
            name, distanceThisInterval, distanceCoveredInMeters);
    }
} 