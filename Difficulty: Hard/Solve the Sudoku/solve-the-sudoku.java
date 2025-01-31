//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = 9;
            int matrix[][] = new int[n][n];
            // String st[] = read.readLine().trim().split("\\s+");
            int k = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ob.solveSudoku(matrix);
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
    // Function to find a solved Sudoku.
    /**
     * Using Recursion and Backtracking
     * 
     * TC: O(1)
     * SC: O(1)
     */
    static void solveSudoku(int[][] mat) {
        solve(mat);
    }
    
    /**
     * TC: O(3 x 9) ~ O(1)
     * SC: O(1)
     */
    private static boolean solve(int[][] mat) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (mat[i][j] == 0) {
                    // try for all possibilities by replacing mat[i][j] with numbers from 0-9
                    for (int num = 1; num <= 9; num++) {
                        if (isSudokuValid(mat, i, j, num)) { // TC: O(1)
                            mat[i][j] = num;
                            // explore
                            if (solve(mat)) {
                                return true;
                            }
                            // backtrack
                            mat[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * TC: O(3 x 9) ~ O(1)
     * SC: O(1)
     */
    private static boolean isSudokuValid(int[][] mat, int i, int j, int num) {
        // check row
        for (int col = 0; col < 9; col++) {
            if (mat[i][col] == num) {
                return false;
            }
        }
        // check column
        for (int row = 0; row < 9; row++) {
            if (mat[row][j] == num) {
                return false;
            }
        }
        // check in 3 x 3 boxes
        int srowCell = i - (i % 3);
        int scolCell = j - (j % 3);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (mat[srowCell + row][scolCell + col] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
