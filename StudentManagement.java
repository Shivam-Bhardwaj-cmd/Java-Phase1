import java.util.*;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    int totalMarks() {
        int sum = 0;
        for(int mark : marks) {
            sum += mark;
        }
        return sum;
    }

    double averageMarks() {
        return totalMarks() / (double) marks.length;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Marks: " + Arrays.toString(marks));
        System.out.println("Total: " + totalMarks());
        System.out.println("Average: " + averageMarks());
    }
}

public class StudentManagement {
  public static Student searchStudent(ArrayList<Student> students, String name) {
        for(Student s : students) {
            if(s.name.equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            sc.nextLine(); // consume newline
            System.out.print("Enter name of student " + (i+1) + ": ");
            String name = sc.nextLine();

            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();
            int[] marks = new int[subjects];

            System.out.println("Enter marks for each subject:");
            for(int j = 0; j < subjects; j++) {
                marks[j] = sc.nextInt();
            }

            students.add(new Student(name, marks));
        }

        System.out.println("\nStudent Results:");
        for(Student s : students) {
            s.display();
            System.out.println("---------------");
        }
students.sort((s1, s2) -> s2.totalMarks() - s1.totalMarks());

System.out.println("\nStudents sorted by total marks:");
for(Student s : students) {
    s.display();
    System.out.println("---------------");
}
sc.nextLine(); // consume newline
        System.out.print("Enter name of student to search: ");
        String searchName = sc.nextLine();

        Student result = searchStudent(students, searchName);
        if(result != null) {
            System.out.println("Student found:");
            result.display();
        } else {
            System.out.println("Student not found.");
        }

        // Find the student with the highest total marks
        Student topStudent = students.get(0);
        for(Student s : students) {
            if(s.totalMarks() > topStudent.totalMarks()) {
                topStudent = s;
            }
        }
        System.out.println("Top student:");
        topStudent.display();

        sc.close();
    }
}

