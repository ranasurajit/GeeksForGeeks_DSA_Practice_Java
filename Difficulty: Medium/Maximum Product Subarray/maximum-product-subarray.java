//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    /**
     * TC: O(2 x N) ~ O(N)
     * SC: O(1)
     */
    int maxProduct(int[] arr) {
        int n = arr.length;
        int left = 1;
        int right = 1;
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;
        // iterating left to right to calculate maxLeft
        for (int i = 0; i < n; i++) {      // TC: O(N)
            left = left * arr[i];
            maxLeft = Math.max(maxLeft, left);
            if (left == 0) {
                left = 1;
            }
        }
        // iterating right to left to calculate maxRight
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            right = right * arr[i];
            maxRight = Math.max(maxRight, right);
            if (right == 0) {
                right = 1;
            }
        }
        return Math.max(maxLeft, maxRight);
    }
}
