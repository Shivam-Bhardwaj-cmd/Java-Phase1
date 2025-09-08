import java.util.Scanner;

public class Day3_2DArrays {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Day 3: 2D Arrays & Advanced Methods ===");

        // Sample 3x3 matrix for exercises 1-5
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Exercise 1: Sum of 2D Array
        System.out.println("\n[Exercise 1] Sum of 2D Array:");
        System.out.println("Sum: " + sum2DArray(matrix));

        // Exercise 2: Largest Element in 2D Array
        System.out.println("\n[Exercise 2] Largest Element:");
        System.out.println("Largest: " + findLargest2D(matrix));

        // Exercise 3: Row & Column Sums
        System.out.println("\n[Exercise 3] Row & Column Sums:");
        printRowAndColumnSums(matrix);

        // Exercise 4: Transpose of 2D Array
        System.out.println("\n[Exercise 4] Transposed Matrix:");
        int[][] transposed = transpose2DArray(matrix);
        printMatrix(transposed);

        // Exercise 5: Search Element
        System.out.println("\n[Exercise 5] Search Element:");
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        int[] position = searchElement(matrix, key);
        if(position[0] != -1) {
            System.out.println("Element found at row " + position[0] + ", column " + position[1]);
        } else {
            System.out.println("Element not found.");
        }

        // Exercise 6: Initialize 2D Array with User Input
        System.out.println("\n[Exercise 6] Initialize Matrix with User Input:");
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();
        int[][] userMatrix = new int[rows][cols];
        initializeUserMatrix(userMatrix, sc);
        System.out.println("Your Matrix:");
        printMatrix(userMatrix);

        sc.close();
    }

    // ------------------- Methods -------------------

    public static int sum2DArray(int[][] arr) {
        int sum = 0;
        for(int[] row : arr) {
            for(int val : row) sum += val;
        }
        return sum;
    }

    public static int findLargest2D(int[][] arr) {
        int largest = arr[0][0];
        for(int[] row : arr) {
            for(int val : row) if(val > largest) largest = val;
        }
        return largest;
    }

    public static void printRowAndColumnSums(int[][] arr) {
        for(int i=0;i<arr.length;i++) {
            int rowSum=0;
            for(int j=0;j<arr[i].length;j++) rowSum+=arr[i][j];
            System.out.println("Sum of row "+i+": "+rowSum);
        }
        for(int j=0;j<arr[0].length;j++) {
            int colSum=0;
            for(int i=0;i<arr.length;i++) colSum+=arr[i][j];
            System.out.println("Sum of column "+j+": "+colSum);
        }
    }

    public static int[][] transpose2DArray(int[][] arr) {
        int rows=arr.length, cols=arr[0].length;
        int[][] transposed=new int[cols][rows];
        for(int i=0;i<rows;i++) for(int j=0;j<cols;j++) transposed[j][i]=arr[i][j];
        return transposed;
    }

    public static void printMatrix(int[][] arr) {
        for(int[] row:arr) {
            for(int val:row) System.out.print(val+" ");
            System.out.println();
        }
    }

    public static int[] searchElement(int[][] arr, int key) {
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[i].length;j++)
                if(arr[i][j]==key) return new int[]{i,j};
        return new int[]{-1,-1};
    }

    public static void initializeUserMatrix(int[][] arr, Scanner sc) {
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr[i].length;j++){
                System.out.print("Enter element ["+i+"]["+j+"]: ");
                arr[i][j]=sc.nextInt();
            }
    }
}
