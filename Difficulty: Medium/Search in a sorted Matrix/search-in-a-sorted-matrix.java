//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int matrix[][] = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution x = new Solution();

            if (x.searchMatrix(matrix, target))
                System.out.println("true");
            else
                System.out.println("false");
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to search a given number in row-column sorted matrix.
    /**
     * TC: O(N x log(M))
     * SC: O(1)
     */
    public boolean searchMatrix(int[][] mat, int x) {
        int m = mat[0].length;
        for (int[] row : mat) { // TC: O(N)
            int low = row[0];
            int high = row[m - 1];
            if (x >= low && x <= high && isFound(row, m, x)) { // TC: O(log(M))
                return true;
            }
        }
        return false;
    }

    /**
     * TC: O(log(M))
     * SC: O(1)
     */
    private static boolean isFound(int[] row, int m, int x) {
        int low = 0;
        int high = m - 1;
        while (low <= high) { // TC: O(log(M))
            int mid = low + (high - low) / 2;
            if (row[mid] == x) {
                return true;
            } else if (row[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
