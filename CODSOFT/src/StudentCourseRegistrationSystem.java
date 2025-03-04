// TASK5: STUDENT COURSE REGISTRATION
import java.util.*;

class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    String schedule;
    List<String> registeredStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }

    public boolean registerStudent(String studentId) {
        if (registeredStudents.size() < capacity) {
            registeredStudents.add(studentId);
            return true;
        }
        return false;
    }

    public boolean removeStudent(String studentId) {
        return registeredStudents.remove(studentId);
    }

    public int availableSlots() {
        return capacity - registeredStudents.size();
    }

    @Override
    public String toString() {
        return "Course Code: " + courseCode + ", Title: " + title + ", Slots Available: " + availableSlots();
    }
}

class Student {
    String studentId;
    String name;
    List<String> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public void addCourse(String courseCode) {
        registeredCourses.add(courseCode);
    } 

    public void removeCourse(String courseCode) {
        registeredCourses.remove(courseCode);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", Registered Courses: " + registeredCourses;
    }
}

public class StudentCourseRegistrationSystem {
    static Map<String, Course> courses = new HashMap<>();
    static Map<String, Student> students = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeData();

        while (true) {
            System.out.println("\n1. List Courses\n2. Register for a Course\n3. Drop a Course\n4. View Student Details\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> listCourses();
                case 2 -> registerForCourse(scanner);
                case 3 -> dropCourse(scanner);
                case 4 -> viewStudentDetails(scanner);
                case 5 -> {
                    System.out.println("Exiting the system...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void initializeData() {
        courses.put("BCSE101", new Course("BCSE101", "Introduction to Programming", "Learn basics of programming.", 30, "MWF 10-11 AM"));
        courses.put("BSHC102", new Course("BSHC102", "Data Structures", "Learn about data structures.", 25, "TTh 2-3:30 PM"));

        students.put("NKS1001", new Student("NKS1001", "KHUSHI SINGH"));
        students.put("KNS1002", new Student("KNS1002", "NIKHIL SINGH"));
    }

    private static void listCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course course : courses.values()) {
            System.out.println(course);
        }
    }

    private static void registerForCourse(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        if (!students.containsKey(studentId)) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        if (!courses.containsKey(courseCode)) {
            System.out.println("Course not found!");
            return;
        }

        Student student = students.get(studentId);
        Course course = courses.get(courseCode);

        if (course.registerStudent(studentId)) {
            student.addCourse(courseCode);
            System.out.println("Registration successful.");
        } else {
            System.out.println("Registration failed. Course is full.");
        }
    }

    private static void dropCourse(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        if (!students.containsKey(studentId)) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        if (!courses.containsKey(courseCode)) {
            System.out.println("Course not found!");
            return;
        }

        Student student = students.get(studentId);
        Course course = courses.get(courseCode);

        if (course.removeStudent(studentId)) {
            student.removeCourse(courseCode);
            System.out.println("Course dropped successfully.");
        } else {
            System.out.println("You are not registered for this course.");
        }
    }

    private static void viewStudentDetails(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        if (!students.containsKey(studentId)) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println(students.get(studentId));
    }
}
