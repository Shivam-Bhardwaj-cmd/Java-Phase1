import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        char op = scanner.next().charAt(0);

        double result;

        if(op == '+') {
            result = num1 + num2;
        } else if(op == '-') {
            result = num1 - num2;
        } else if(op == '*') {
            result = num1 * num2;
        } else if(op == '/') {
            result = num1 / num2;
        } else {
            System.out.println("Invalid operator!");
            scanner.close();
            return;
        }

        System.out.println("Result: " + result);
        scanner.close();
    }
}
