import java.util.*;

public class StudentManager {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Thank You! Exiting...");
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 5);
    }

    private static void addStudent() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.print("Enter new Name: ");
        student.name = scanner.nextLine();

        System.out.print("Enter new Marks: ");
        student.marks = scanner.nextDouble();

        System.out.println("Student updated.");
    }

    private static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        Student student = findStudentById(id);

        if (student != null) {
            students.remove(student);
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static Student findStudentById(int id) {
        for (Student s : students) {
            if (s.id == id) return s;
        }
        return null;
    }
}