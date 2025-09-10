import java.util.Scanner;

public class Day7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the size of the matrix
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        // Input the matrix elements
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Rotate the matrix
        rotate90(matrix, n);

        // Print the rotated matrix
        printMatrix(matrix, n);

        sc.close();
    }

    // Method to rotate the matrix by 90 degrees clockwise
    public static void rotate90(int[][] matrix, int n) {
        // Step 1: Transpose the matrix
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for(int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;
            while(start < end) {
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }

    // Method to print the matrix
    public static void printMatrix(int[][] matrix, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

