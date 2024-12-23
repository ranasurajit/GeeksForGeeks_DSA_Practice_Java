//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

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

            int k = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            int ans = ob.maximumSumSubarray(arr, k);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Took two pointers i and j = 0 and increment j till window size of 'k' is reached
     * 
     * Window size: (j - i + 1)
     * 
     * when window size < k, then keep increasing j
     * when window size = k, remove arr[i] from sum and 
     * maintain this, by incrementing both i an j
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int maximumSumSubarray(int[] arr, int k) {
        int n = arr.length;
        int i = 0; // start index of sliding window
        int j = 0; // end index of sliding window
        long sum = 0L;
        long maxSum = Long.MIN_VALUE;
        // j will reach till last index of array 'arr'
        while (j < n) { // TC: O(N)
            sum += arr[j];
            if (j - i + 1 < k) {
                // window size of k is not achieved yet
                j++;
            } else if (j - i + 1 == k) {
                // window size of k is achieved
                maxSum = Math.max(maxSum, sum);
                // exclude arr[i] from sum
                sum = sum - arr[i];
                // increment i so that window is moved to start index i++
                i++;
                j++;
            }
        }
        return (int) maxSum;
    }
}
