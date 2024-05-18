import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


// Class to represent a Student
class Student {
    private String std_id;
    private String std_name;
    private int std_age;
    private String std_email;
    //Method for initializing the student details
    public Student(String std_id, String std_name, int std_age, String std_email) {
        this.std_id = std_id;
        this.std_name = std_name;
        this.std_age = std_age;
        this.std_email = std_email;
    }
    //Using Get methods 
    public String getId() {
        return std_id;
    }
    public String getName() {
        return std_name;
    }
    public int getAge() {
        return std_age;
    }
    public String getEmail() {
        return std_email;
    }
    // Override toString() for easy printing in furthur program
    @Override
    public String toString() {
        return "Student{" +
                "id='" + std_id + '\'' +
                ", name='" + std_name + '\'' +
                ", age=" + std_age +
                ", email='" + std_email + '\'' +
                '}';
    }
}

//Defining a Class to represent a Course
class Course {
    private String course_id;
    private String course_name;
    //Initializations for course details
    public Course(String course_id, String course_name) {
        this.course_id = course_id;
        this.course_name = course_name;
    }
    // Get method for class course
    public String getCourseId() {
        return course_id;
    }
    public String getCourseName() {
        return course_name;
    }
    // Override toString() for easy printing in further cases
    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + course_id + '\'' +
                ", courseName='" + course_name + '\'' +
                '}';
    }
}
//Defining a class to represent an Enrollment (relationship between Student and Course)
class Enrollment {
    private Student student;
    private Course std_course;
    private int std_grade;
    //Initializations for enrolling a course by student
    public Enrollment(Student student, Course std_course, int std_grade) {
        this.student = student;
        this.std_course = std_course;
        this.std_grade = std_grade;
    }
    // Get methods for class enrollment
    public Student getStudent() {
        return student;
    }
    public Course getCourse() {
        return std_course;
    }
    public int getGrade() {
        return std_grade;
    }
    // Override toString() for easy printing
    @Override
    public String toString() {
        return "Enrollment{" +
                "student=" + student +
                ", course=" + std_course +
                ", std_grade=" + std_grade +
                '}';
    }
}
// Main class to working and display info of our Student Information System(SIS)
public class StudentInfoSystem {
    private List<Student> students;
    private List<Course> courses;
    private List<Enrollment> enrollments;
    //Declaring lists for storing student,course and enrollments details
    public StudentInfoSystem() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        enrollments = new ArrayList<>();
    }
    //Defining Method to add a new student
    public void addStudent(Student student) {
        students.add(student);
    }
    //Defining Method to add a new course
    public void addCourse(Course std_course) {
        courses.add(std_course);
    }
    //Defining Method to enroll a student in a course
    public void enrollStudent(Student student, Course std_course, int std_grade) {
        Enrollment std_enrollment = new Enrollment(student, std_course, std_grade);
        enrollments.add(std_enrollment);
    }
    //Defining Method to print all students
    public void printAllStudents() {
        System.out.println("All Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    //Defining Method to print all courses
    public void printAllCourses() {
        System.out.println("All Courses:");
        for (Course std_course : courses) {
            System.out.println(std_course);
        }
    }
    //Defining Method to print all enrollments
    public void printAllEnrollments() {
        System.out.println("All Enrollments:");
        for (Enrollment std_enrollment : enrollments) {
            System.out.println(std_enrollment);
        }
    }
    //Defining Main method to interact with the main class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentInfoSystem sins = new StudentInfoSystem();
        //Adding some initial students and courses for knowledge purpose
        sins.addStudent(new Student("1", "Snehalatha", 18, "gogurisnehalatha@gmail.com"));
        sins.addStudent(new Student("2", "Rahul", 21, "gogurirahul@gmail.com"));
        sins.addCourse(new Course("C1", "Maths"));
        sins.addCourse(new Course("C2", "Python"));
        //Runs until its true
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student");
            System.out.println("4. Print All Students");
            System.out.println("5. Print All Courses");
            System.out.println("6. Print All Enrollments");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            //Switch case for all our requirements for SIS
            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String studentId = sc.nextLine();
                    System.out.print("Enter student name: ");
                    String studentName = sc.nextLine();
                    System.out.print("Enter student age: ");
                    int studentAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter student email: ");
                    String studentEmail = sc.nextLine();
                    sins.addStudent(new Student(studentId, studentName, studentAge, studentEmail));
                    break;
                case 2:
                    System.out.print("Enter course ID: ");
                    String course_id = sc.nextLine();
                    System.out.print("Enter course name: ");
                    String course_name = sc.nextLine();
                    sins.addCourse(new Course(course_id, course_name));
                    break;
                case 3:
                    System.out.print("Enter student ID to enroll: ");
                    String enrollStudentId = sc.nextLine();
                    System.out.print("Enter course ID to enroll: ");
                    String enrollCourseId = sc.nextLine();
                    System.out.print("Enter grade: ");
                    int std_grade = sc.nextInt();
                    sc.nextLine(); 
                    Student studentToEnroll = sins.students.stream().filter(s -> s.getId().equals(enrollStudentId)).findFirst().orElse(null);
                    Course courseToEnroll = sins.courses.stream().filter(c -> c.getCourseId().equals(enrollCourseId)).findFirst().orElse(null);
                    if (studentToEnroll != null && courseToEnroll != null) {
                        sins.enrollStudent(studentToEnroll, courseToEnroll, std_grade);
                        System.out.println("Student enrolled successfully.");
                    } else {
                        System.out.println("Student or course not found.");
                    }
                    break;
                case 4:
                    sins.printAllStudents();
                    break;
                case 5:
                    sins.printAllCourses();
                    break;
                case 6:
                    sins.printAllEnrollments();
                    break;
		        case 7:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option as shown!!");
            }
        }
    }
          }
