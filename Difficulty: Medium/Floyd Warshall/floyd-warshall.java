//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().trim().split(" ");
                for (int j = 0; j < n; j++) matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortestDistance(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function template for JAVA

class Solution {
    /**
     * Using Floyd Warshall Algorithm
     * 
     * TC: O(N ^ 3 + 2 x N ^ 2) ~ O(N ^ 3)
     * SC: O(1)
     * 
     * @param mat
     */
    public void shortestDistance(int[][] mat) {
        int n = mat.length; // n x n matrix
        /**
         * adding bigger value than one mentioned in constraints 
         * against (i, j) which has no edge
         */
        for (int i = 0; i < n; i++) {         // TC: O(N)
            for (int j = 0; j < n; j++) {     // TC: O(N)
                if (mat[i][j] == -1) {
                    mat[i][j] = 1001;         // as -1 <= mat[i][j] <= 1000
                }
            }
        }
        // calculating shortest path by Floyd Warshall Algorithm
        for (int via = 0; via < n; via++) {   // TC: O(N)
            for (int i = 0; i < n; i++) {     // TC: O(N)
                for (int j = 0; j < n; j++) { // TC: O(N)
                    mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                }
            }
        }
        // reverting back the values for (i, j) which has no edge
        for (int i = 0; i < n; i++) {         // TC: O(N)
            for (int j = 0; j < n; j++) {     // TC: O(N)
                if (mat[i][j] == 1001) {
                    mat[i][j] = -1;
                }
            }
        }
    }
}
