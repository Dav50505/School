import java.util.Scanner;

public class TempConversion { 
    public static void main(String[] args) {
 // Create Scanner object for user input
         Scanner scanner = new Scanner(System.in);
         
         // Prompt user for Fahrenheit temperature
         System.out.print("Enter temperature in Fahrenheit : ");
         
         // Read and store the Fahrenheit temperature
         double fahrenheit = scanner.nextDouble();
         
         // Convert to Kelvin and store result
         double kelvin = fahrenheitToKelvin(fahrenheit);
         
         // Display the result with proper formatting
         System.out.printf("\n%.2f degrees from Fahrenheit to Kelvin is %.2f\n", 
                          fahrenheit, kelvin);
         
         // Close the scanner
         scanner.close();
     }
     
     public static double fahrenheitToKelvin(double fahrenheit) {
         // Convert Fahrenheit to Kelvin using the formula:
         // K = (F - 32) * 5/9 + 273.15
         return (fahrenheit - 32) * 5.0/9.0 + 273.15;
     }
    
 }