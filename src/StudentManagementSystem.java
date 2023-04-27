import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String Firstname,grade;
    private int id;

    public Student(String name, int id, String grade) {
        this.Firstname = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return Firstname;
    }

    public int getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

class StudentManagement {
    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void displayAllStudents() {
        System.out.println("List of all students:");
        for (Student student : students) {
            System.out.println("Name : "+student.getName() + ", ID : " + student.getId() + ", Grade : " + student.getGrade());
        }
    }

    public void updateStudentGrade(int id, String newGrade) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setGrade(newGrade);
                break;
            }
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentManagement management = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Student Management System");
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Display all students");
            System.out.println("4. Update student grade");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student Firstname: ");
                    String name = scanner.next();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter student grade: ");
                    String grade = scanner.next();

                    Student student = new Student(name, id, grade);
                    management.addStudent(student);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter student ID: ");
                    int removeId = scanner.nextInt();

                    for (Student s : management.students) {
                        if (s.getId() == removeId) {
                            management.removeStudent(s);
                            System.out.println("Student removed successfully.");
                            break;
                        }
                    }
                    break;
                    	
                case 3:
                    management.displayAllStudents();
                    break;

                case 4:
                    System.out.print("Enter student ID: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.next();

                    management.updateStudentGrade(updateId, newGrade);
                    System.out.println("Grade updated successfully.");
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}