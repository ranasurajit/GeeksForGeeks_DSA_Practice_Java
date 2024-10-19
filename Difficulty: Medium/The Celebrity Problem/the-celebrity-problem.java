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
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        int v = mat.length;
        int[] indegrees = new int[v];
        int[] outdegrees = new int[v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (i != j && mat[i][j] == 1) {
                    indegrees[j]++;
                    outdegrees[i]++;
                }
            }
        }
        /**
         * the node having outdegrees = 0 and indegrees = v - 1 is the celebrity
         * as the celebrity is one who does not know anyone but everyone else knows
         * the celebrity
         */
        for (int i = 0; i < v; i++) {
            if (outdegrees[i] == 0 && indegrees[i] == v - 1) {
                return i;
            }
        }
        return -1;
    }
}
