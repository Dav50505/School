import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDatabase database = new StudentDatabase();
        
        System.out.print("Enter Database Filename: ");
        String filename = scanner.nextLine();
        
        if (!database.loadFromFile(filename)) {
            System.out.println("*** Error: File Not Found. ***");
            scanner.close();
            return;
        }
        
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Enter Choice #: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        registerNewStudent(scanner, database);
                        break;
                    case 2:
                        displayStudentRecord(scanner, database);
                        break;
                    case 3:
                        updateStudentRecord(scanner, database);
                        break;
                    case 4:
                        displayHighestGradeStudent(database);
                        break;
                    case 5:
                        displayLowestGradeStudent(database);
                        break;
                    case 6:
                        running = false;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
        
        scanner.close();
    }
    
    private static void displayMenu() {
        System.out.println("Select an action:");
        System.out.println("1. Register New Student");
        System.out.println("2. Display Existing Student Record");
        System.out.println("3. Update Existing Student Record");
        System.out.println("4. Display Student with Highest Grade");
        System.out.println("5. Display Student with Lowest Grade");
        System.out.println("6. Exit");
    }
    
    private static void registerNewStudent(Scanner scanner, StudentDatabase database) {
        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Student Grade: ");
        double grade = Double.parseDouble(scanner.nextLine());
        
        database.registerNewStudent(id, name, grade);
    }
    
    private static void displayStudentRecord(Scanner scanner, StudentDatabase database) {
        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        Student student = database.findStudent(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("*** Error - Student ID Not Found! ***");
        }
    }
    
    private static void updateStudentRecord(Scanner scanner, StudentDatabase database) {
        System.out.print("Enter Student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        
        Student student = database.findStudent(id);
        if (student != null) {
            System.out.println(student);
            
            System.out.print("Enter New Grade: ");
            double newGrade = Double.parseDouble(scanner.nextLine());
            
            database.updateStudentGrade(id, newGrade);
        } else {
            System.out.println("*** Error - Student ID Not Found! ***");
        }
    }
    
    private static void displayHighestGradeStudent(StudentDatabase database) {
        Student student = database.findHighestGradeStudent();
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("No students in the database.");
        }
    }
    
    private static void displayLowestGradeStudent(StudentDatabase database) {
        Student student = database.findLowestGradeStudent();
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("No students in the database.");
        }
    }
}