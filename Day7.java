import java.util.Scanner;

public class Day7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of the matrix
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        // Input the matrix elements
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Check if symmetric and print the result
        if(isSymmetric(matrix, n)) {
            System.out.println("Symmetric");
        } else {
            System.out.println("Not Symmetric");
        }

        sc.close();
    }

    // Method to check if the matrix is symmetric
    public static boolean isSymmetric(int[][] matrix, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}

