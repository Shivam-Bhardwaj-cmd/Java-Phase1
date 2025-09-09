import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();

        int sum = 0;

        for(int i = 1; i <= n; i++) {
            sum = sum + i;
        }

        System.out.println("The sum of first " + n + " natural numbers is: " + sum);

        scanner.close();
    }
}
