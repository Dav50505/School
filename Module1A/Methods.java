import java.util.Scanner;

public class Methods {
    public static void main(String[] args) {
        // Declare and instantiate a Scanner
        Scanner scnr = new Scanner(System.in);

        // Continue serving method selection menu
        // until "Exit" option is selected
        int selection;
        do {
            System.out.print(
                    "\nMethod Selection Menu\n" +
                            "=======================\n" +
                            "1. Temperature Conversion (Fahrenheit to Celsius)\n" +
                            "2. Distance Conversion (Yards to Feet and Inches)\n" +
                            "3. Get Acronym\n" +
                            "4. Triangle Generator\n" +
                            "5. Exit\n" +
                            "=======================\n" +
                            "Enter selection (1-5): ");
            try {
                selection = Integer.parseInt(scnr.next());
            } catch(NumberFormatException ex) {
                selection = 0;
            }
            switch (selection) {
                case 1:
                    doTempConversion(scnr);
                    break;
                case 2:
                    doDistConversion(scnr);
                    break;
                case 3:
                    // flush input buffer
                    if (scnr.hasNextLine())
                        scnr.nextLine();

                    doGetAcronym(scnr);
                    break;
                case 4:
                    doTriangle(scnr);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Error: Invalid option");
            }
        } while (selection != 5);
        scnr.close();
    }

    public static void doTempConversion(Scanner scnr) {

        // Below this comment: declare any other variables you may need
        // to store the user's input and the Celsius equivalent value
        double fahrenheit = 0;
        double celsius = 0;

        // Below this comment: prompt the user to enter the required input(s)

        System.out.print("Enter the temperature in Fahrenheit: ");

        // Below this comment: collect the required input(s) from the user

        fahrenheit = scnr.nextDouble();

        // Below this comment: call your fahrenheitToCelsius method

        celsius = fahrenheitToCelsius(fahrenheit);

        // Below this comment: display the required results

        System.out.printf("%.2f degrees Fahrenheit is %.2f Celsius%n", fahrenheit, celsius);

    }

    // define your fahrenheitToCelsius method here below

    public static double fahrenheitToCelsius(double fahrenheit){
        return (5.0 / 9.0) * (fahrenheit - 32);
    }

    public static void doDistConversion(Scanner scnr) {
        
        // Below this comment: declare any other variables you may need
        // to store the user's input and the Feet and Inches equivalent value
        double yards = 0;
        String feetAndInches = "";
        

        // Below this comment: collect the required inputs
        System.out.print("Enter the distance in Yards: ");
        yards = scnr.nextDouble();

        // Below this comment: call your yardsToFeetAndInches method
        feetAndInches = yardsToFeetAndInches(yards);

        // Below this comment: disply the required results
        System.out.printf("%.2f yards in Feet and Inches is: %s", yards, feetAndInches);
    }

    // define your yardsToFeetAndInches method here below
    public static String yardsToFeetAndInches(double yards){
        double totalInches = yards * 36;
        int feet = (int) (totalInches / 12);
        double inches = totalInches % 12;
        return String.format("%d' %.2f\"", feet, inches);
    }

    public static void doGetAcronym(Scanner scnr) {
        String sentence = "";
        String acronym = "";

        System.out.print("Enter some words: ");
        sentence = scnr.nextLine();
        acronym = getAcronym(sentence);
        System.out.printf("Acronym for %s : %s%n", sentence, acronym);
    }

    // define your getAcronym method here below
    public static String getAcronym(String sentence){
        String acronym = "";
        int indexOfSpace = 0;
        acronym += sentence.charAt(indexOfSpace);
        indexOfSpace = sentence.indexOf(" ");
        while(indexOfSpace >= 0){
            acronym += sentence.charAt(indexOfSpace + 1);
            indexOfSpace = sentence.indexOf(" ", indexOfSpace+1);
        }
        acronym = acronym.toUpperCase();
        return acronym;
    }


    public static void doTriangle(Scanner scnr) {
        int size = 0;
        String border = "";
        String interior = "";

        System.out.print("Enter size     : ");
        size = scnr.nextInt();
        System.out.print("Enter border   : ");
        border = scnr.next();
        System.out.print("Enter interior : ");
        interior = scnr.next();

        for(int i=0; i<=size; i++){
            for(int j = 0; j<i; j++){
                if(j==0 || j==i-1 || i==size){
                    System.out.print(border);
                }
                else{
                    System.out.print(interior);
                }
            }
            System.out.println();
        }

    }

}