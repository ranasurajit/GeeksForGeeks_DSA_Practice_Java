//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    /**
     * TC: O(N x K)
     * SC: O(N)
     */
    public int minimizeCost(int k, int arr[]) {
        int n = arr.length;
        int[] dp = new int[n]; // SC: O(N)
        dp[0] = 0; // best (min) cost till index 0
        dp[1] = Math.abs(arr[1] - arr[0]) + dp[0]; // best (min) cost till index 1
        for (int i = 1; i < n; i++) { // TC: O(N)
            int minCost = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.min(i, k); j++) { // TC: O(K)
                minCost = Math.min(minCost, Math.abs(arr[i] - arr[i - j]) + dp[i - j]);
            }
            dp[i] = minCost; // best (min) cost till index i
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