import java.util.Scanner;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N: ");
        double n = scanner.nextDouble();

        double sum = 0;
        for(int i = 1; i <= (int)n; i++) {
            sum += i;
        }

        System.out.println("Sum of first " + (int)n + " numbers is: " + sum);

        scanner.close();
    }
}
