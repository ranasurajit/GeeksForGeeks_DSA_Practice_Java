//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.rotateby90(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) System.out.print(matrix[i][j] + " ");
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to rotate matrix anticlockwise by 90 degrees.
    /**
     * TC: O(N ^ 2 + N) ~ O(N ^ 2)
     * SC: O(1)
     */
    static void rotateby90(int mat[][]) {
        int n = mat.length;
        // transpose the matrix
        transposeMatrix(mat, n);
        // reverse the rows array
        reverseArray(mat, n);
    }
    
    /**
     * TC: O(N x N)
     * SC: O(1)
     */
    private static void transposeMatrix(int mat[][], int n) {
        for (int i = 0; i < n; i++) {     // TC: O(N)
            for (int j = 0; j < i; j++) { // TC: O(N)
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
    
    /**
     * TC: O(N)
     * SC: O(1)
     */
    private static void reverseArray(int mat[][], int n) {
        int start = 0;
        int end = n - 1;
        while (start < end) {
            int[] temp = mat[start];
            mat[start] = mat[end];
            mat[end] = temp;
            start++;
            end--;
        }
    }
}
