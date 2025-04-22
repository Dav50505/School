public class Main {
    public static void main(String[] agrs) {
       // you may write code in this main method to test your required method
       
    }
    
    // define your required method here below
    public static int minMaxDiff(int a, int b, int c) {
        // Find minimum value
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        
        // Find maximum value
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        
        // Return positive difference
        return max - min;
    }
}