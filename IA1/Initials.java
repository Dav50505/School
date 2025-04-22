public class Initials {
    public static String toInitials(String name) {
        // Handle empty or null input
        if (name == null || name.trim().isEmpty()) {
            return "";
        }
        
        // Split the name into parts
        String[] parts = name.trim().split("\\s+");
        StringBuilder initials = new StringBuilder();
        
        // Process each part of the name
        for (int i = 0; i < parts.length; i++) {
            if (!parts[i].isEmpty()) {
                // Add the first character of each part
                initials.append(parts[i].charAt(0));
                // Add period and space if not the last part
                if (i < parts.length - 1) {
                    initials.append(". ");
                } else {
                    initials.append(".");
                }
            }
        }
        
        return initials.toString();
    }
    
    public static void main(String[] args) {
        // Create Scanner for user input
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter name : ");
        String name = scanner.nextLine();
        
        // Get initials
        String initials = toInitials(name);
        
        // Display results
        System.out.println("For " + name + " initials are : " + initials);
        
        // Close scanner
        scanner.close();
    }
}
