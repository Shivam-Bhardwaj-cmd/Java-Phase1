import java.util.ArrayList;
import java.util.Scanner;

public class Day5_StudentStringManager {

    // Method to reverse a string
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    // Method to check palindrome
    public static boolean isPalindrome(String str) {
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        return cleaned.equals(reverseString(cleaned));
    }

    // Method to count vowels and consonants
    public static void countVowelsConsonants(String str) {
        int vowels = 0, consonants = 0;
        str = str.toLowerCase();
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                if ("aeiou".indexOf(c) != -1) vowels++;
                else consonants++;
            }
        }
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }

    // Method to format student details
    public static void printStudentDetails(String name, int id) {
        System.out.printf("Student ID: %d, Name: %s%n", id, name);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume leftover newline

        // Input student names
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            studentNames.add(sc.nextLine());
        }

        System.out.println("\n--- Student Name Operations ---");

        int id = 1;
        for (String name : studentNames) {
            System.out.println("\nOriginal Name: " + name);
            System.out.println("Uppercase: " + name.toUpperCase());
            System.out.println("Lowercase: " + name.toLowerCase());
            System.out.println("Reversed: " + reverseString(name));
            System.out.println("Is Palindrome? " + isPalindrome(name));
            countVowelsConsonants(name);
            printStudentDetails(name, id++);
        }

        sc.close();
    }
}

