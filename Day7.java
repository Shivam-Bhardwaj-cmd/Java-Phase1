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

        // Input the element to search for
        int x = sc.nextInt();

        // Count occurrences
        int count = countOccurrences(matrix, n, m, x);

        // Print the result
        System.out.println(count);

        sc.close();
    }

    // Method to count occurrences of x in the matrix
    public static int countOccurrences(int[][] matrix, int n, int m, int x) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == x) {
                    count++;
                }
            }
        }
        return count;
    }
}

