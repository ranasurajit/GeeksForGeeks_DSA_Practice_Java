//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        // Loop for each test case
        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution(); // Create an object of Solution class
            System.out.println(
                ob.perfectSum(nums, target)); // Call perfectSum and print the result
            System.out.println("~");          // Call perfectSum and print the result
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to calculate the number of subsets with a given sum
    /**
     * Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     * 
     * @param nums
     * @param target
     * @return
     */
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;

        // Initialize a 2D memoization table with -1
        int[][] memo = new int[n + 1][target + 1];
        for (int[] row : memo)
            Arrays.fill(row, -1);
     
        return countSubsets(0, 0, target, nums, memo);
    }
    
    int countSubsets(int i, int currentSum, int target, 
                                   int[] arr, int[][] memo) {
        int n = arr.length;

        // Base case: If we've processed all elements in the array
        if (i == n)
          
            // Return 1 if the current subset's sum 
            // equals the target, else return 0
            return (currentSum == target) ? 1 : 0;

        // Check if the result for the current state
         // is already computed
        if (memo[i][currentSum] != -1)
            return memo[i][currentSum];

        // Case 1: Exclude the current element
        int exclude = countSubsets(i + 1, currentSum, target, arr, memo);

        // Case 2: Include the current element
        int include = 0;
        if (currentSum + arr[i] <= target)
            include = countSubsets(i + 1, currentSum + arr[i],
                                   target, arr, memo);

        // Store the result in the memoization 
         // table and return it
        memo[i][currentSum] = include + exclude;
        return memo[i][currentSum];
    }
}
