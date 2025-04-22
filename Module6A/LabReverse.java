public class LabReverse {
    public static String reverse(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
    
    public static void main(String[] args) {
        System.out.println(reverse("abc"));    // Should print: cba
        System.out.println(reverse("hello"));  // Should print: olleh
        System.out.println(reverse(""));       // Should print: 
        System.out.println(reverse("a"));      // Should print: a
        System.out.println(reverse("12345"));  // Should print: 54321
    }
} 