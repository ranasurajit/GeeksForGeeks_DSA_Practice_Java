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
     * Approach : Floyd Warshall Algorithm
     * 
     * TC: O(N ^ 3)
     * SC: O(1)
     */
    public void floydWarshall(int[][] dist) {
        int n = dist.length;
        // we need to calculate shortest distance from node1 to node 2 via all other nodes
        for (int via = 0; via < n; via++) {   // TC: O(N)
            for (int i = 0; i < n; i++) {     // TC: O(N)
                for (int j = 0; j < n; j++) { // TC: O(N)
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }
        // no need to check negative weight cycles
    }
}
