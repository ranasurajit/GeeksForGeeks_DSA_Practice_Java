//{ Driver Code Starts
import java.io.*;
import java.util.*;

class gfg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int w = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] tokens = line.split(" ");
            List<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] val = new int[array.size()];
            int idx = 0;
            for (int i : array) val[idx++] = i;

            String lin = br.readLine();
            String[] toke = lin.split(" ");
            List<Integer> array1 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : toke) {
                array1.add(Integer.parseInt(token));
            }

            int[] wt = new int[array1.size()];
            idx = 0;
            for (int i : array1) wt[idx++] = i;

            // calling method knapSack() of class Solution
            System.out.println(new Solution().knapSack(w, wt, val));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int[] dp1D : dp) {
            Arrays.fill(dp1D, -1);
        }
        return solve(W, wt, val, n - 1, dp);
    }
    
    private static int solve(int W, int[] wt, int[] val, int index, int[][] dp) {
        // base condition
        if (index < 0) {
            return 0;
        }
        if (dp[index][W] != -1) {
            return dp[index][W];
        }
        // pick
        int x = 0;
        if (W - wt[index] >= 0) {
            x = val[index] + solve(W - wt[index], wt, val, index - 1, dp);
        }
        // not pick
        int y = solve(W, wt, val, index - 1, dp);
        dp[index][W] = Math.max(x, y);
        return dp[index][W];
    }
}
