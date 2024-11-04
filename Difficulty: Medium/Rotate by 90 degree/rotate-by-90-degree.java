//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();

            GFG g = new GFG();
            g.rotate(arr);
            printMatrix(arr);

            System.out.println("~");
        }
    }

    static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class GFG {
    /**
     * TC: O(2 x N x N) ~ O(N x N)
     * SC: O(1)
     */
    static void rotate(int matrix[][]) {
        int n = matrix.length; // as it is square matrix
        // transpose the matrix
        transpose(matrix);                      // TC: O(N x N)
        // reverse each arrays in the rows
        for (int[] row : matrix) {              // TC: O(N x N)
            reverse(row, 0, n - 1);
        }
    }
    
    /**
     * TC: O(N x N)
     * SC: O(1)
     */
    private static void transpose(int[][] matrix) {
        int n = matrix.length; // as it is square matrix
        for (int i = 1; i < n; i++) {         // TC: O(N)
            for (int j = 0; j < i; j++) {     // TC: O(N)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    /**
     * TC: O(N)
     * SC: O(1)
     */
    private static void reverse(int[] row, int start, int end) {
        while (start < end) {
            int temp = row[end];
            row[end] = row[start];
            row[start] = temp;
            start++;
            end--;
        }
    }
}
