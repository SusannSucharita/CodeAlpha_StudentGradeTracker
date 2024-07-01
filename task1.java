import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Double> studentGrades = new ArrayList<>();
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter name for student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            studentNames.add(name);
            double grade;
            while (true) {
                System.out.print("Enter grade for " + name + ":");
                grade = scanner.nextDouble();
                if (grade >= 0.00 && grade <= 10.00) {
                    break;
                } else {
                    System.out.println("Invalid grade. Please enter a grade between 0.00 and 10.00.");
                }
            }
            scanner.nextLine();
            studentGrades.add(grade);
        }
        double sum = 0;
        for (double grade : studentGrades) {
            sum += grade;
        }
        double average = sum / studentGrades.size();
        double highest = Collections.max(studentGrades);
        double lowest = Collections.min(studentGrades);
        System.out.printf("Average grade: %.2f\n", average);
        System.out.printf("Highest grade: %.2f\n", highest);
        System.out.printf("Lowest grade: %.2f\n", lowest);
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Look up a student's grade");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.print("Enter the name of the student to get their grade: ");
                String queryName = scanner.nextLine();
                boolean studentFound = false;
                for (int i = 0; i < studentNames.size(); i++) {
                    if (studentNames.get(i).equalsIgnoreCase(queryName)) {
                        System.out.printf("%s's grade: %.2f\n", studentNames.get(i), studentGrades.get(i));
                        studentFound = true;
                        break;
                    }
                }
                if (!studentFound) {
                    System.out.println("Student not found.");
                }
            } else if (choice == 2) {
                System.out.println("Exiting the program.");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}