//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) mat[i][j] = sc.nextInt();
            }

            int x = sc.nextInt();

            if (new Solution().matSearch(mat, x))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * TC: O(N x log(M))
     * SC: O(1)
     */
    public static boolean matSearch(int mat[][], int x) {
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
