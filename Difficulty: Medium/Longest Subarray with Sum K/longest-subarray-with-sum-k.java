//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int k = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            int ans = ob.longestSubarray(nums, k); // Call the function and store result
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Using HashMap and PrefixSum Approach
     * (Works even if elements are negative)
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int maxLength = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        map.put(0, -1); // needed to get length when at any index sum becomes k
        int i = 0;
        while (i < n) { // TC: O(N)
            currentSum += arr[i];
            int diff = currentSum - k;
            if (map.containsKey(diff)) {
                maxLength = Math.max(maxLength, i - map.get(diff));
            }
            if (!map.containsKey(currentSum)) { // needed to include 0 elements
                map.put(currentSum, i);
            }
            i++;
        }
        return maxLength;
    }
    
    /**
     * Using Two Pointers Sliding Window Approach 
     * (Does not work if elements are negative)
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int longestSubarrayForPositives(int[] arr, int k) {
        int n = arr.length;
        int maxLength = 0;
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        int sum = 0;
        while (j < n) { // TC: O(N)
            sum += arr[j];
            while (i < j && sum > k) {
                sum -= arr[i];
                i++;
            }
            if (sum == k) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
            j++;
        }
        return maxLength;
    }
}
