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
    /**
     * Using Space Optimization
     * TC: O(3 x 4 x N)
     * SC: O(4) ~ O(1)
     * 
     * @param arr
     * @param N
     * @return
     */
    public int maximumPoints(int arr[][], int N) {
        /**
         * We need to store a prev array of size 4 (3 tasks (0, 1, 2) + 1 No task (3))
         */
        int[] prev = new int[4]; // SC: O(4)
        prev[0] = Math.max(arr[0][1], arr[0][2]); // if task 0 was chosen as last task
        prev[1] = Math.max(arr[0][0], arr[0][2]); // if task 1 was chosen as last task
        prev[2] = Math.max(arr[0][0], arr[0][1]); // if task 2 was chosen as last task
        prev[3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2])); // if task 2 was chosen as last task

        for (int day = 1; day < N; day++) { // TC: O(N)
            int[] current = new int[4]; // SC: O(4)
            for (int last = 0; last <= 3; last++) { // TC: O(4)
                current[last] = 0;
                for (int task = 0; task <= 2; task++) { // TC: O(3)
                    if (task != last) {
                        int points = arr[day][task] + prev[task];
                        current[last] = Math.max(current[last], points);
                    }
                }
            }
            prev = current;
        }
        return prev[3];
    }
    
    /**
     * Using Tabulation
     * TC: O(3 x 4 x N)
     * SC: O(4 x N)
     * 
     * @param arr
     * @param N
     * @return
     */
    public int maximumPointsTabulation(int arr[][], int N) {
        /**
         * We need a dp array of size N x 4 (N days and 3 tasks (0, 1, 2) + 1 No task
         * (3))
         */
        int[][] dp = new int[N][4]; // SC: O(4 x N)
        dp[0][0] = Math.max(arr[0][1], arr[0][2]); // if task 0 was chosen as last task
        dp[0][1] = Math.max(arr[0][0], arr[0][2]); // if task 1 was chosen as last task
        dp[0][2] = Math.max(arr[0][0], arr[0][1]); // if task 2 was chosen as last task
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2])); // if task 2 was chosen as last task

        for (int day = 1; day < N; day++) { // TC: O(N)
            for (int last = 0; last <= 3; last++) { // TC: O(4)
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) { // TC: O(3)
                    if (task != last) {
                        int points = arr[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], points);
                    }
                }
            }
        }
        return dp[N - 1][3];
    }
    
    /**
     * Using Memoization
     * TC: O(3 x 4 x N)
     * SC: O(4 x N + R), where R is the Recursive stack space where R = N
     * 
     * @param arr
     * @param N
     * @return
     */
    public int maximumPointsMemoization(int arr[][], int N) {
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
