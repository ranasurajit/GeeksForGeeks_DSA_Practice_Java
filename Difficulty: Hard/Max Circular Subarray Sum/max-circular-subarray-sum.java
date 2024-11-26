//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {

    // a: input array
    // n: size of array
    // Function to find maximum circular subarray sum.
    /**
     * Optimal Approach - Using Kadane's Algorithm
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int circularSubarraySum(int arr[]) {
        int n = arr.length;
        int currentSumMin = 0;
        int currentSumMax = 0;
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int totalSum = 0;
        // Using Kadane's Algorithm to find minimum sub-array sum
        for (int i = 0; i < n; i++) { // TC: O(N)
            currentSumMin += arr[i];
            currentSumMax += arr[i];
            minSum = Math.min(minSum, currentSumMin);
            maxSum = Math.max(maxSum, currentSumMax);
            if (currentSumMin > 0) {
                currentSumMin = 0;
            }
            if (currentSumMax < 0) {
                currentSumMax = 0;
            }
            totalSum += arr[i];
        }
        // case 1: Linear array - max sum of linear array
        // case 2: Circular array - total sum = max circular sub-array sum + min sub-array sum
        return Math.max(maxSum, totalSum - minSum);
    }
}
