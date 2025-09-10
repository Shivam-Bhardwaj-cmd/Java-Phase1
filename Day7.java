import java.util.Scanner;

public class Day7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the size of the matrix
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];

        // Input the matrix elements
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Find and print saddle points
        boolean found = false;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(isSaddlePoint(matrix, n, m, i, j)) {
                    System.out.println("Saddle point: " + matrix[i][j]);
                    found = true;
                }
            }
        }

        if(!found) {
            System.out.println("No saddle point found");
        }

        sc.close();
    }

    // Method to check if element at (row, col) is a saddle point
    public static boolean isSaddlePoint(int[][] matrix, int n, int m, int row, int col) {
        int element = matrix[row][col];

        // Check if element is minimum in its row
        for(int j = 0; j < m; j++) {
            if(matrix[row][j] < element) {
                return false;
            }
        }

        // Check if element is maximum in its column
        for(int i = 0; i < n; i++) {
            if(matrix[i][col] > element) {
                return false;
            }
        }

        return true;
    }
}

