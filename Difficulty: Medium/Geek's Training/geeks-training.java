//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr, N);
            System.out.println(res);
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][], int N) {
        /**
         * We need a dp array of size N x 4 (N days and 3 tasks (0, 1, 2) + 1 No task
         * (3))
         */
        int[][] dp = new int[N][4];
        for (int[] dp1D : dp) {
            Arrays.fill(dp1D, -1);
        }
        /*
         * last is 3 - tasks types (0, 1, 2 and 3 is for no task
         * performed on Nth day (out of bound))
         */
        return solveMemoization(N - 1, 3, arr, dp);
    }
    
    private static int solveMemoization(int index, int last, int[][] arr, int[][] dp) {
        // Base case
        if (index == 0) {
            int maxPoints = 0;
            // 0th day when last is the index performed on 1st day
            for (int i = 0; i <= 2; i++) { // i denotes the type of task (0, 1 or 2)
                if (i != last) {
                    int points = arr[0][i];
                    maxPoints = Math.max(maxPoints, points);
                }
            }
            return maxPoints;
        }
        if (dp[index][last] != -1) {
            return dp[index][last];
        }
        int maxPoints = 0;
        for (int task = 0; task <= 2; task++) {
            if (task != last) {
                int points = arr[index][task] + solveMemoization(index - 1, task, arr, dp);
                maxPoints = Math.max(maxPoints, points);
            }
        }
        dp[index][last] = maxPoints;
        return dp[index][last];
    }
    
    public int maximumPointRecursion(int arr[][], int N) {
        /*
         * last is 3 - tasks types (0, 1, 2 and 3 is for no task
         * performed on Nth day (out of bound))
         */
        return solveRecursion(N - 1, 3, arr);
    }
    
    private static int solveRecursion(int index, int last, int[][] arr) {
        // Base case
        if (index == 0) {
            int maxPoints = 0;
            // 0th day when last is the index performed on 1st day
            for (int i = 0; i <= 2; i++) { // i denotes the type of task (0, 1 or 2)
                if (i != last) {
                    int points = arr[0][i];
                    maxPoints = Math.max(maxPoints, points);
                }
            }
            return maxPoints;
        }
        int maxPoints = 0;
        for (int task = 0; task <= 2; task++) {
            if (task != last) {
                int points = arr[index][task] + solveRecursion(index - 1, task, arr);
                maxPoints = Math.max(maxPoints, points);
            }
        }
        return maxPoints;
    }
}
