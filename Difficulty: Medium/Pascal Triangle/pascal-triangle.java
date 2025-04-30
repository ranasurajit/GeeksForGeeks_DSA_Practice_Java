//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            ArrayList<Integer> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);

            System.out.println("~");
        }
    }

    public static void printAns(ArrayList<Integer> ans) {
        for (Integer x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach: Using Simulation
     * 
     * TC: O(N ^ 2 + N) ~ O(N ^ 2)
     * SC: O(N ^ 2)
     */
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        boolean isEven = (n & 1) == 0;
        int m = isEven ? n + 1 : n;
        int[][] triangle = new int[m][m];
        triangle[0][m / 2] = 1;
        for (int i = 1; i < n; i++) { // TC: O(N)
            for (int j = 0; j <= i; j++) { // TC: O(N)
                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int j = 0; j < n; j++) { // TC: O(N)
            result.add(triangle[n - 1][j]);
        }
        return result;
    }
}
