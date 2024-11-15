//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    static Boolean isSubsetSum(int arr[], int target) {
        int n = arr.length;
        int[][] dp = new int[n][target + 1];
        for (int[] dp1D : dp) {
            Arrays.fill(dp1D, -1);
        }
        return solve(n - 1, target, arr, dp);
    }
    
    private static Boolean solve(int index, int target, int[] arr, int[][] dp) {
        // Base case
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return arr[0] == target;
        }
        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }
        Boolean pick = false;
        if (target >= arr[index]) {
            pick = solve(index - 1, target - arr[index], arr, dp);
        }
        Boolean notpick = solve(index - 1, target, arr, dp);
        dp[index][target] = pick || notpick ? 1 : 0;
        return pick || notpick;
    }
}
