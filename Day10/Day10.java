import java.util.Scanner;

public class Day10 {
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Java Day 10: Advanced Matrix Practice ===");
        int choice;
        int[][] matrix = null;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Input Matrix");
            System.out.println("2. Print Matrix");
            System.out.println("3. Spiral Traversal");
            System.out.println("4. Boundary Traversal");
            System.out.println("5. Wave Traversal");
            System.out.println("6. Diagonal Traversal");
            System.out.println("7. Rotate 90° Clockwise");
            System.out.println("8. Rotate 90° Anticlockwise");
            System.out.println("9. Upper Triangular");
            System.out.println("10. Lower Triangular");
            System.out.println("11. Sum of Border Elements");
            System.out.println("12. Check Symmetric Matrix");
            System.out.println("13. Multiply Two Matrices");
            System.out.println("14. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    matrix = inputMatrix();
                    break;
                case 2:
                    printMatrix(matrix);
                    break;
                case 3:
                    spiralTraversal(matrix);
                    break;
                case 4:
                    boundaryTraversal(matrix);
                    break;
                case 5:
                    waveTraversal(matrix);
                    break;
                case 6:
                    diagonalTraversal(matrix);
                    break;
                case 7:
                    rotate90Clockwise(matrix);
                    break;
                case 8:
                    rotate90AntiClockwise(matrix);
                    break;
                case 9:
                    printUpperTriangular(matrix);
                    break;
                case 10:
                    printLowerTriangular(matrix);
                    break;
                case 11:
                    System.out.println("Sum of border elements: " + sumBorderElements(matrix));
                    break;
                case 12:
                    System.out.println("Symmetric: " + isSymmetric(matrix));
                    break;
                case 13:
                    System.out.println("Enter second matrix to multiply:");
                    int[][] matrix2 = inputMatrix();
                    int[][] result = multiplyMatrices(matrix, matrix2);
                    System.out.println("Multiplication Result:");
                    printMatrix(result);
                    break;
                case 14:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while(choice != 14);
    }

    // ------------------ Input Matrix ------------------
    static int[][] inputMatrix() {
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();
        int[][] mat = new int[n][m];
        System.out.println("Enter matrix elements:");
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                mat[i][j] = sc.nextInt();
        return mat;
    }

    // ------------------ Print Matrix ------------------
    static void printMatrix(int[][] matrix) {
        if(matrix == null) { System.out.println("Matrix not initialized."); return; }
        for(int[] row : matrix) {
            for(int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

    // ------------------ Spiral Traversal ------------------
    static void spiralTraversal(int[][] matrix) {
        if(matrix == null) { System.out.println("Matrix not initialized."); return; }
        int top=0, bottom=matrix.length-1;
        int left=0, right=matrix[0].length-1;
        System.out.println("Spiral Traversal:");
        while(top<=bottom && left<=right){
            for(int j=left;j<=right;j++) System.out.print(matrix[top][j]+" ");
            top++;
            for(int i=top;i<=bottom;i++) System.out.print(matrix[i][right]+" ");
            right--;
            if(top<=bottom){
                for(int j=right;j>=left;j--) System.out.print(matrix[bottom][j]+" ");
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--) System.out.print(matrix[i][left]+" ");
                left++;
            }
        }
        System.out.println();
    }

    // ------------------ Boundary Traversal ------------------
    static void boundaryTraversal(int[][] matrix){
        if(matrix == null) { System.out.println("Matrix not initialized."); return; }
        int n = matrix.length, m = matrix[0].length;
        System.out.println("Boundary Traversal:");
        for(int j=0;j<m;j++) System.out.print(matrix[0][j]+" ");
        for(int i=1;i<n;i++) System.out.print(matrix[i][m-1]+" ");
        if(n>1) for(int j=m-2;j>=0;j--) System.out.print(matrix[n-1][j]+" ");
        if(m>1) for(int i=n-2;i>0;i--) System.out.print(matrix[i][0]+" ");
        System.out.println();
    }

    // ------------------ Wave Traversal ------------------
    static void waveTraversal(int[][] matrix){
        if(matrix == null) { System.out.println("Matrix not initialized."); return; }
        int n=matrix.length, m=matrix[0].length;
        System.out.println("Wave Traversal:");
        for(int j=0;j<m;j++){
            if(j%2==0) for(int i=0;i<n;i++) System.out.print(matrix[i][j]+" ");
            else for(int i=n-1;i>=0;i--) System.out.print(matrix[i][j]+" ");
        }
        System.out.println();
    }

    // ------------------ Diagonal Traversal ------------------
    static void diagonalTraversal(int[][] matrix){
        if(matrix == null) { System.out.println("Matrix not initialized."); return; }
        int n=matrix.length, m=matrix[0].length;
        System.out.println("Diagonal Traversal:");
        for(int col=0; col<m; col++){
            int i=0, j=col;
            while(i<n && j>=0){
                System.out.print(matrix[i][j]+" ");
                i++; j--;
            }
            System.out.println();
        }
        for(int row=1; row<n; row++){
            int i=row, j=m-1;
            while(i<n && j>=0){
                System.out.print(matrix[i][j]+" ");
                i++; j--;
            }
            System.out.println();
        }
    }

    // ------------------ Rotate 90° Clockwise ------------------
    static void rotate90Clockwise(int[][] matrix){
        if(matrix == null) { System.out.println("Matrix not initialized."); return; }
        int n = matrix.length;
        // Transpose
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        // Reverse rows
        for(int i=0;i<n;i++){
            int left=0,right=n-1;
            while(left<right){
                int temp = matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++; right--;
            }
        }
        System.out.println("Rotated 90° Clockwise:");
        printMatrix(matrix);
    }

    // ------------------ Rotate 90° Anticlockwise ------------------
    static void rotate90AntiClockwise(int[][] matrix){
        if(matrix == null) { System.out.println("Matrix not initialized."); return; }
        int n = matrix.length;
        // Transpose
        for(int i=0;i<n;i++)
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        // Reverse columns
        for(int j=0;j<n;j++){
            int top=0, bottom=n-1;
            while(top<bottom){
                int temp = matrix[top][j];
                matrix[top][j]=matrix[bottom][j];
                matrix[bottom][j]=temp;
                top++; bottom--;
            }
        }
        System.out.println("Rotated 90° Anticlockwise:");
        printMatrix(matrix);
    }

    // ------------------ Upper Triangular ------------------
    static void printUpperTriangular(int[][] matrix){
        if(matrix == null) { System.out.println("Matrix not initialized."); return; }
        int n = matrix.length;
        System.out.println("Upper Triangular Matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i<=j) System.out.print(matrix[i][j]+" ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }

    // ------------------ Lower Triangular ------------------
    static void printLowerTriangular(int[][] matrix){
        if(matrix == null) { System.out.println("Matrix not initialized."); return; }
        int n = matrix.length;
        System.out.println("Lower Triangular Matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>=j) System.out.print(matrix[i][j]+" ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }

    // ------------------ Sum of Border Elements ------------------
    static int sumBorderElements(int[][] matrix){
        if(matrix == null) { System.out.println("Matrix not initialized."); return 0; }
        int n=matrix.length, m=matrix[0].length, sum=0;
        for(int j=0;j<m;j++){
            sum+=matrix[0][j];
            if(n>1) sum+=matrix[n-1][j];
        }
        for(int i=1;i<n-1;i++){
            sum+=matrix[i][0];
            if(m>1) sum+=matrix[i][m-1];
        }
        return sum;
    }

    // ------------------ Check Symmetric Matrix ------------------
    static boolean isSymmetric(int[][] matrix){
        if(matrix == null) { System.out.println("Matrix not initialized."); return false; }
        int n=matrix.length;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(matrix[i][j]!=matrix[j][i]) return false;
        return true;
    }

    // ------------------ Multiply Two Matrices ------------------
    static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2){
        int n=matrix1.length, m=matrix1[0].length, p=matrix2[0].length;
        int[][] result = new int[n][p];
        for(int i=0;i<n;i++)
            for(int j=0;j<p;j++)
                for(int k=0;k<m;k++)
                    result[i][j]+=matrix1[i][k]*matrix2[k][j];
        return result;
    }
}

