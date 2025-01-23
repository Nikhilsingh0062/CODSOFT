//TASK2: STUDENT GRADE CALCULATOR
import java.util.Scanner;

public class StudentGradeCalculator {

    // for calculate total marks
    public static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    // for calculate average percentage
    public static double calculateAveragePercentage(int totalMarks, int numberOfSubjects) {
        return (double) totalMarks / numberOfSubjects;
    }

    // for calculate grade
    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    // for display results
    public static void displayResults(int totalMarks, double averagePercentage, String grade) {
        System.out.println("\n--- Student Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        int[] marks = new int[numberOfSubjects];
        System.out.println("Enter the marks obtained in each subject (out of 100):");
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            // Validating marks
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks entered! Please enter marks between 0 and 100.");
                i--; // Retry for  same subject
            }
        }

        // Calculate total marks, average percentage,grade
        int totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAveragePercentage(totalMarks, numberOfSubjects);
        String grade = calculateGrade(averagePercentage);

        // Displaying results
        displayResults(totalMarks, averagePercentage, grade);

        scanner.close();
    }
}
