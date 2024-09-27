//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int minimizeCost(int k, int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 0; // cost at 1st stone is zero as Geek is standing there
        // dp[1] = arr[1] - arr[0];
        // dp[2] = Math.abs(arr[2] - arr[1]) + dp[1];
        // dp[i] needs to be found where dp[i] = min cost to reach at ith stone
        // ith stone can be reached from (i - 1)th, (i - 2)th ... (i - k)th stone
        for (int i = 1; i < n; i++) {
            int cost = Integer.MAX_VALUE;
            for (int j = 1; j <= k && j <= i; j++) {
                cost = Math.min(cost, Math.abs(arr[i] - arr[i - j]) + dp[i - j]);
            }
            dp[i] += cost;
        }
        return dp[n - 1];
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.minimizeCost(k, arr);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends