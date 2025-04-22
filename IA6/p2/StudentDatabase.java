import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDatabase {
    private BinarySearchTree<Student> bst;
    private List<Student> allStudents;

    public StudentDatabase() {
        bst = new BinarySearchTree<>();
        allStudents = new ArrayList<>();
    }

    public boolean loadFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                
                String[] parts = line.split("\\s+", 4);
                if (parts.length >= 4) {
                    int id = Integer.parseInt(parts[0]);
                    String firstName = parts[1];
                    String lastName = parts[2];
                    double grade = Double.parseDouble(parts[3]);
                    
                    Student student = new Student(id, firstName + " " + lastName, grade);
                    bst.insert(student);
                    allStudents.add(student);
                }
            }
            scanner.close();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
            return false;
        }
    }

    public void registerNewStudent(int id, String name, double grade) {
        Student student = new Student(id, name, grade);
        bst.insert(student);
        allStudents.add(student);
    }

    public Student findStudent(int id) {
        return bst.search(new Student(id, "", 0));
    }

    public void updateStudentGrade(int id, double newGrade) {
        Student student = findStudent(id);
        if (student != null) {
            student.setGrade(newGrade);
        }
    }

    public Student findHighestGradeStudent() {
        if (allStudents.isEmpty()) {
            return null;
        }
        
        final Student[] highest = {null};
        
        bst.inOrderTraversal(new BinarySearchTree.NodeVisitor<Student>() {
            @Override
            public void visit(Student student) {
                if (highest[0] == null || student.getGrade() > highest[0].getGrade()) {
                    highest[0] = student;
                }
            }
        });
        
        return highest[0];
    }

    public Student findLowestGradeStudent() {
        if (allStudents.isEmpty()) {
            return null;
        }
        
        final Student[] lowest = {null};
        
        bst.inOrderTraversal(new BinarySearchTree.NodeVisitor<Student>() {
            @Override
            public void visit(Student student) {
                if (lowest[0] == null || student.getGrade() < lowest[0].getGrade()) {
                    lowest[0] = student;
                }
            }
        });
        
        return lowest[0];
    }
} 