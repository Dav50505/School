public class Converter {
    public static String metersToFeetAndInches(double meters) {
        // Convert meters to inches (1 meter = 39.37 inches)
        double totalInches = meters * 39.37;
        
        // Calculate feet (1 foot = 12 inches)
        int feet = (int)(totalInches / 12);
        
        // Calculate remaining inches
        double inches = totalInches % 12;
        
        // Format the result with 2 decimal places for inches
        return String.format("%d' %.2f\"", feet, inches);
    }
    
    public static void main(String[] args) {
        // Create Scanner for user input
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter distance in Meters : ");
        double meters = scanner.nextDouble();
        
        // Convert meters to feet and inches
        String result = metersToFeetAndInches(meters);
        
        // Display the result
        System.out.printf("%.2f meters is : %s%n", meters, result);
        
        // Close the scanner
        scanner.close();
    }
}
