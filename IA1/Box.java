import java.util.Scanner;

public class Box {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get user input
        System.out.print("Enter width    : ");
        int width = scanner.nextInt();
        
        System.out.print("Enter height   : ");
        int height = scanner.nextInt();
        
        System.out.print("Enter interior : ");
        char interior = scanner.next().charAt(0);
        
        System.out.print("Enter border   : ");
        char border = scanner.next().charAt(0);
        
        // Print a blank line after input
        System.out.println();
        
        // Draw the box
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                // Print border for first/last row or first/last column
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    System.out.print(border);
                } else {
                    System.out.print(interior);
                }
            }
            System.out.println();
        }
        
        scanner.close();
    }
}
