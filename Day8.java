import java.util.Arrays;
import java.util.Scanner;

public class Day8 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] sharedMatrix = null; // To reuse when running all problems
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("\n=== Day 8 Java Practice ===");
            System.out.println("Choose a problem to run (1-5), 6 to run all, 0 to exit:");
            System.out.println("1: Row & Column Sum");
            System.out.println("2: Diagonal Sum");
            System.out.println("3: Search in 2D Matrix");
            System.out.println("4: Sort Each Row");
            System.out.println("5: Find Peaks");
            System.out.println("6: Run All Problems (reuse same matrix)");
            System.out.println("0: Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 0 -> {
                    System.out.println("Exiting program. Goodbye!");
                    continueProgram = false;
                }
                case 1 -> rowColumnSum(chooseMatrix());
                case 2 -> diagonalSum(chooseMatrix());
                case 3 -> search2D(chooseMatrix());
                case 4 -> sortRows(chooseMatrix());
                case 5 -> findPeaks(chooseMatrix());
                case 6 -> {
                    if (sharedMatrix == null) {
                        System.out.println("Enter matrix once for all problems or press 0 to use example:");
                        sharedMatrix = chooseMatrix();
                    }
                    runAllProblems(sharedMatrix);
                }
                default -> System.out.println("Invalid choice! Enter 0-6.");
            }

            if (continueProgram) {
                System.out.print("\nDo you want to continue? (yes/no): ");
                String ans = sc.next().trim().toLowerCase();
                if (ans.equals("no") || ans.equals("n")) continueProgram = false;
            }
        }

        sc.close();
    }

    // Choose matrix: either custom input or example
    static int[][] chooseMatrix() {
        System.out.print("Enter 1 for custom input, 0 for example matrix: ");
        int option = sc.nextInt();
        if (option == 1) {
            return inputMatrix();
        } else {
            // Example matrix (3x3)
            return new int[][] {
                {10, 20, 15},
                {21, 30, 14},
                {7, 16, 32}
            };
        }
    }

    static int[][] inputMatrix() {
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter matrix elements row by row:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    static void runAllProblems(int[][] matrix) {
        rowColumnSum(matrix);
        diagonalSum(matrix);
        search2D(matrix);
        sortRows(matrix);
        findPeaks(matrix);
    }

    static void rowColumnSum(int[][] matrix) {
        System.out.println("\n=== Row & Column Sum ===");
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[i].length; j++) rowSum += matrix[i][j];
            System.out.println("Sum of row " + i + ": " + rowSum);
        }

        for (int j = 0; j < matrix[0].length; j++) {
            int colSum = 0;
            for (int i = 0; i < matrix.length; i++) colSum += matrix[i][j];
            System.out.println("Sum of column " + j + ": " + colSum);
        }
    }

    static void diagonalSum(int[][] matrix) {
        if (matrix.length != matrix[0].length) {
            System.out.println("Matrix must be square for diagonal sum!");
            return;
        }
        int primary = 0, secondary = 0, n = matrix.length;
        for (int i = 0; i < n; i++) {
            primary += matrix[i][i];
            secondary += matrix[i][n - 1 - i];
        }
        System.out.println("\n=== Diagonal Sum ===");
        System.out.println("Primary: " + primary + ", Secondary: " + secondary);
    }

    static void search2D(int[][] matrix) {
        System.out.print("Enter element to search: ");
        int target = sc.nextInt();
        boolean found = false;

        System.out.println("\n=== Search in 2D Matrix ===");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    System.out.println("Element found at (" + i + ", " + j + ")");
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        if (!found) System.out.println("Element not found");
    }

    static void sortRows(int[][] matrix) {
        System.out.println("\n=== Sort Each Row ===");
        for (int i = 0; i < matrix.length; i++) Arrays.sort(matrix[i]);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    static void findPeaks(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        System.out.println("\n=== Find Peaks in Matrix ===");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int current = matrix[i][j];
                boolean isPeak = true;

                for (int r = i - 1; r <= i + 1; r++) {
                    for (int c = j - 1; c <= j + 1; c++) {
                        if (r >= 0 && r < rows && c >= 0 && c < cols) {
                            if (!(r == i && c == j) && matrix[r][c] >= current) isPeak = false;
                        }
                    }
                }
                if (isPeak) System.out.println("Peak element: " + current + " at (" + i + ", " + j + ")");
            }
        }
    }
}

