// Day6_2DArrayPractice.java
import java.util.Scanner;

public class Day6_2DArrayPractice {

    // Method to print a 2D array
    public static void printMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Sum of all elements in a 2D array
    public static int sumMatrix(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
        }
        return sum;
    }

    // Find maximum element in a 2D array
    public static int findMax(int[][] mat) {
        int max = mat[0][0];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] > max) {
                    max = mat[i][j];
                }
            }
        }
        return max;
    }

    // Row-wise sum
    public static void rowSum(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
            System.out.println("Sum of row " + i + ": " + sum);
        }
    }

    // Column-wise sum
    public static void colSum(int[][] mat) {
        for (int j = 0; j < mat[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < mat.length; i++) {
                sum += mat[i][j];
            }
            System.out.println("Sum of column " + j + ": " + sum);
        }
    }

    // Search for an element
    public static boolean searchMatrix(int[][] mat, int target) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == target) {
                    System.out.println("Found at: (" + i + "," + j + ")");
                    return true;
                }
            }
        }
        return false;
    }

    // Matrix addition
    public static int[][] addMatrices(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] sum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        return sum;
    }

    // Matrix transpose
    public static int[][] transposeMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] transpose = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = mat[i][j];
            }
        }
        return transpose;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input a 2D array
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];
        System.out.println("Enter elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nOriginal Matrix:");
        printMatrix(matrix);

        // Sum of elements
        System.out.println("\nSum of all elements: " + sumMatrix(matrix));

        // Maximum element
        System.out.println("Maximum element: " + findMax(matrix));

        // Row-wise sum
        rowSum(matrix);

        // Column-wise sum
        colSum(matrix);

        // Search for an element
        System.out.print("Enter element to search: ");
        int target = sc.nextInt();
        if (!searchMatrix(matrix, target)) {
            System.out.println("Element not found.");
        }

        // Matrix addition example (2x2)
        int[][] mat1 = {{1, 2}, {3, 4}};
        int[][] mat2 = {{5, 6}, {7, 8}};
        System.out.println("\nMatrix Addition Result:");
        printMatrix(addMatrices(mat1, mat2));

        // Matrix transpose
        System.out.println("\nTranspose of Original Matrix:");
        printMatrix(transposeMatrix(matrix));

        sc.close();
    }
}

