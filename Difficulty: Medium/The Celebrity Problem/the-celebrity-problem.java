//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach II : Using Two Pointers Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int celebrity(int mat[][]) {
        int n = mat.length;
        int top = 0;
        int bottom = n - 1;
        
        while (top < bottom) { // TC: O(N)
            if (mat[top][bottom] == 1) {
                // index 'top' cannot be celebrity
                top++;
            } else if (mat[bottom][top] == 1) {
                // index 'bottom' cannot be celebrity
                bottom--;
            } else if (mat[top][bottom] == 0 && mat[bottom][top] == 0) {
                // both 'top' and 'bottom' indices cannot be celebrity
                top++;
                bottom--;
            }
        }
        if (top > bottom) {
            return -1;
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (i == top) {
                continue;
            }
            if (mat[top][i] == 0 && mat[i][top] == 1) {
                // do nothing as we have the celebrity as top or bottom
            } else {
                return -1;
            }
        }
        return top;
    }

    /**
     * Approach I : Using Graph (Indegrees and Outdegrees) Approach
     * 
     * TC: O(N ^ 2 + N) ~ O(N ^ 2)
     * SC: O(2 x N) ~ O(N)
     */
    public int celebrityUsingGraphs(int mat[][]) {
        int n = mat.length;
        int[] indegrees = new int[n];  // SC: O(N)
        int[] outdegrees = new int[n]; // TC: O(N)
        
        for (int i = 0; i < n; i++) {     // TC: O(N)
            for (int j = 0; j < n; j++) { // TC: O(N)
                if (i != j && mat[i][j] == 1) {
                    indegrees[j]++;
                    outdegrees[i]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {    // TC: O(N)
            if (outdegrees[i] == 0 && indegrees[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
