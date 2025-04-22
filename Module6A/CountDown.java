public class CountDown {
    // Recursive method to count down from n to 0
    public static void countDown(int n) {
        // Base case: when n is 0, print it and stop
        if (n == 0) {
            System.out.println(n);
            return;
        }
        // Print current number
        System.out.println(n);
        // Recursive call with n-1
        countDown(n - 1);
    }

    // Given recursive method to count up from 0 to n
    public static void countUp(int n) {
        if (n == 0) {
            System.out.println(n);
            return;
        }
        countUp(n - 1);
        System.out.println(n);
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("Counting down from 5:");
        countDown(5);
        
        System.out.println("\nCounting up to 5:");
        countUp(5);
    }
} 