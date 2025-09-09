import java.util.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("Name: " + name + ", Marks: " + marks);
    }
}

public class Day4_StudentExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for(int i = 0; i < n; i++) {
            System.out.print("Enter name of student " + (i+1) + ": ");
            String name = sc.nextLine();
            System.out.print("Enter marks of student " + (i+1) + ": ");
            int marks = sc.nextInt();
            sc.nextLine(); // consume newline
            students.add(new Student(name, marks));
        }

        System.out.println("\nStudent details:");
        for(Student s : students) {
            s.display();
        }

        sc.close();
    }
}

