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

        // Call the spiral traversal method
        spiralTraversal(matrix, n, m);

        sc.close();
    }

    // Method to print the spiral order of the matrix
    public static void spiralTraversal(int[][] matrix, int n, int m) {
        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        while(top <= bottom && left <= right) {

            // Traverse from left to right
            for(int j = left; j <= right; j++) {
                System.out.print(matrix[top][j] + " ");
            }
            top++;

            // Traverse from top to bottom
            for(int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }
            right--;

            // Traverse from right to left if still rows remain
            if(top <= bottom) {
                for(int j = right; j >= left; j--) {
                    System.out.print(matrix[bottom][j] + " ");
                }
                bottom--;
            }

            // Traverse from bottom to top if still columns remain
            if(left <= right) {
                for(int i = bottom; i >= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }
        }
    }
}

