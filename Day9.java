import java.util.Scanner;

public class Day9 {

    // 1️⃣ Sum of Each Diagonal
    static void sumDiagonals(int[][] matrix) {
        int n = matrix.length;
        int primary = 0, secondary = 0;

        for (int i = 0; i < n; i++) {
            primary += matrix[i][i];
            secondary += matrix[i][n - 1 - i];
        }

        System.out.println("Original Matrix:");
        printMatrix(matrix);
        System.out.println("Primary Diagonal Sum: " + primary);
        System.out.println("Secondary Diagonal Sum: " + secondary);
    }

    // 2️⃣ Rotate Matrix by 180° (returns a new matrix)
    static int[][] rotate180(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] rotated = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rotated[i][j] = matrix[n - 1 - i][m - 1 - j];
            }
        }

        return rotated;
    }

    // 3️⃣ Extended Saddle Points
    static void extendedSaddlePoints(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean found = false;

        System.out.println("Matrix:");
        printMatrix(matrix);

        for (int i = 0; i < n; i++) {
            int rowMin = matrix[i][0];
            int colIndex = 0;
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] < rowMin) {
                    rowMin = matrix[i][j];
                    colIndex = j;
                }
            }

            boolean isSaddle = true;
            for (int k = 0; k < n; k++) {
                if (matrix[k][colIndex] > rowMin) {
                    isSaddle = false;
                    break;
                }
            }

            if (isSaddle) {
                System.out.println("Saddle Point: " + rowMin + " at (" + i + "," + colIndex + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No Saddle Points found.");
        }
    }

    // 4️⃣ Max Sum Submatrix of size k×k
    static void maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;
        int startRow = 0, startCol = 0;

        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {
                int sum = 0;
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        sum += matrix[x][y];
                    }
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    startRow = i;
                    startCol = j;
                }
            }
        }

        System.out.println("Matrix:");
        printMatrix(matrix);
        System.out.println("Max sum " + k + "x" + k + " submatrix: " + maxSum);
        System.out.println("Top-left corner at: (" + startRow + "," + startCol + ")");
    }

    // 5️⃣ Snake Pattern Traversal
    static void snakeTraversal(int[][] matrix) {
        System.out.println("Matrix:");
        printMatrix(matrix);

        int n = matrix.length;
        int m = matrix[0].length;

        System.out.println("Snake Pattern Traversal:");
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
        System.out.println();
    }

    // Print matrix
    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Main method with interactive menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();

        int[][] matrix = new int[n][m];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Sum of Diagonals");
            System.out.println("2. Rotate 180°");
            System.out.println("3. Extended Saddle Points");
            System.out.println("4. Max Sum Submatrix");
            System.out.println("5. Snake Traversal");
            System.out.println("6. Run All Problems");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sumDiagonals(matrix);
                    break;
                case 2:
                    int[][] rotated = rotate180(matrix);
                    System.out.println("Original Matrix:");
                    printMatrix(matrix);
                    System.out.println("Matrix after 180° rotation:");
                    printMatrix(rotated);
                    break;
                case 3:
                    extendedSaddlePoints(matrix);
                    break;
                case 4:
                    System.out.print("Enter k for k×k submatrix: ");
                    int k = sc.nextInt();
                    maxSumSubmatrix(matrix, k);
                    break;
                case 5:
                    snakeTraversal(matrix);
                    break;
                case 6:
                    sumDiagonals(matrix);
                    printMatrix(rotate180(matrix));
                    extendedSaddlePoints(matrix);
                    System.out.print("Enter k for k×k submatrix: ");
                    int kAll = sc.nextInt();
                    maxSumSubmatrix(matrix, kAll);
                    snakeTraversal(matrix);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}

