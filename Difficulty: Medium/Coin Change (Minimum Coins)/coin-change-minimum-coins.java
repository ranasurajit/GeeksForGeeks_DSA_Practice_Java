//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    /**
     * Approach II : Using Memoization Approach
     * 
     * TC: O(N x T)
     * SC: O(N x T + T)
     * 
     * where T = target sum
     */
    public int minCoins(int coins[], int sum) {
        int n = coins.length;
        int[][] memo = new int[n + 1][sum + 1];
        for (int[] memoItem : memo) {
            Arrays.fill(memoItem, -1);
        }
        int numCoins = solveMemoization(n, sum, coins, memo);
        return numCoins == (int) 1e9 ? -1 : numCoins;
    }
    
    /**
     * Using Memoization Approach
     * 
     * TC: O(N x T)
     * SC: O(T)
     * 
     * where T = target sum
     */
    private int solveMemoization(int n, int sum, int[] coins, int[][] memo) {
        // Base Case
        // if (n == 1) {
        //     return sum % coins[0] == 0 ? sum / coins[0] : (int) 1e9;
        // }
        if (n == 0 && sum == 0) {
            return 0;
        }
        if (n == 0 && sum != 0) {
            return (int) 1e9;
        }
        if (n != 0 && sum == 0) {
            return 0;
        }
        // Memoization Check
        if (memo[n][sum] != -1) {
            return memo[n][sum];
        }
        // Recursion Calls
        if (coins[n - 1] <= sum) {
            // we have two options to pick and not pick
            int pick = 1 + solveMemoization(n, sum - coins[n - 1], coins, memo);
            int notpick = solveMemoization(n - 1, sum, coins, memo);
            return memo[n][sum] = Math.min(pick, notpick);
        } else {
            // we have only one option not to pick
            return memo[n][sum] = solveMemoization(n - 1, sum, coins, memo);
        }
    }
    
    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: >> O(2 ^ N)
     * SC: O(T)
     */
    public int minCoinsRecursion(int coins[], int sum) {
        int n = coins.length;
        int numCoins = solveRecursion(n, sum, coins);
        return numCoins == (int) 1e9 ? -1 : numCoins;
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: >> O(2 ^ N)
     * SC: O(T)
     */
    private int solveRecursion(int n, int sum, int[] coins) {
        // Base Case
        // if (n == 1) {
        //     return sum % coins[0] == 0 ? sum / coins[0] : (int) 1e9;
        // }
        if (n == 0 && sum == 0) {
            return 0;
        }
        if (n == 0 && sum != 0) {
            return (int) 1e9;
        }
        if (n != 0 && sum == 0) {
            return 0;
        }
        // Recursion Calls
        if (coins[n - 1] <= sum) {
            // we have two options to pick and not pick
            int pick = 1 + solveRecursion(n, sum - coins[n - 1], coins);
            int notpick = solveRecursion(n - 1, sum, coins);
            return Math.min(pick, notpick);
        } else {
            // we have only one option not to pick
            return solveRecursion(n - 1, sum, coins);
        }
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
            int res = obj.minCoins(arr, k);

            System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends