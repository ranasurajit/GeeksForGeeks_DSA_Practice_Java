//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            new Solution().setMatrixZeroes(arr);
            for (int[] row : arr) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    /**
     * TC: O(3 x (N x M)) ~ O(N x M)
     * SC: O(N + M)
     */
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Set<Integer> rSet = new HashSet<Integer>(); // SC: O(N)
        Set<Integer> cSet = new HashSet<Integer>(); // SC: O(M)
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 0; j < m; j++) { // TC: O(M)
                if (mat[i][j] == 0) {
                    rSet.add(i);
                    cSet.add(j);
                }
            }
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (rSet.contains(i)) {
                for (int j = 0; j < m; j++) { // TC: O(M)
                    mat[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) { // TC: O(M)
            if (cSet.contains(i)) {
                for (int j = 0; j < n; j++) { // TC: O(N)
                    mat[j][i] = 0;
                }
            }
        }
    }
}
