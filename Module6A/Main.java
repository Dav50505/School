class Main {
    public static void main(String[] args) {
 
    }
 
    public static void countUp(int to) {
       if (to < 0)
          return;
 
       countUp(to - 1);
       System.out.println(to);
    }

    public static void countDown(int from) {
        if (from < 0)
            return;

        System.out.println(from);
        countDown(from - 1);
    }
    
    public static String reverse(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
    
    public static boolean isPalindrome(String str) {
        // Base case: empty string or single character is a palindrome
        if (str == null || str.length() <= 1) {
            return true;
        }
        
        // Check if first and last characters are the same
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        
        // Recursive case: check if the substring without first and last characters is a palindrome
        return isPalindrome(str.substring(1, str.length() - 1));
    }
    
    public static int sumOfOdds(int[] arr) {
        // Base case: empty array
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        // Calculate sum of odds in this array
        return sumOfOddsHelper(arr, 0);
    }
    
    private static int sumOfOddsHelper(int[] arr, int index) {
        // Base case: reached the end of array
        if (index >= arr.length) {
            return 0;
        }
        
        // Check if current element is odd
        int currentValue = arr[index];
        int valueIfOdd = (currentValue % 2 != 0) ? currentValue : 0;
        
        // Recursive call to process the rest of the array
        return valueIfOdd + sumOfOddsHelper(arr, index + 1);
    }
    
    public static int count(Node root) {
        // Base case: if the node is null, return 0
        if (root == null) {
            return 0;
        }
        
        // Recursive case: count this node + count of left subtree + count of right subtree
        return 1 + count(root.left) + count(root.right);
    }
 }