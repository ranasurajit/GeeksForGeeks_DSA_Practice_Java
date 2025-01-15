//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int T = Integer.parseInt(br.readLine());

        // Process each test case
        while (T-- > 0) {
            // Read the entire line containing the array elements
            String line = br.readLine();

            // Split the line into an array of strings, then parse them as integers
            String[] tokens = line.split("\\s+");
            int[] a = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                a[i] = Integer.parseInt(tokens[i]);
            }

            // Create the Solution object
            Solution obj = new Solution();

            // Call maxLen function and print the result
            System.out.println(obj.maxLen(a));
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Using Prefix Sum and Hashing Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public int maxLen(int[] arr) {
        int n = arr.length;
        // replace 0s with -1s
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        // now the problem became simple to find length of longest subarray with sum = 0
        HashMap<Long, Integer> map = new HashMap<Long, Integer>(); // SC: O(N)
        map.put(0L, -1); // needed to calculate if sum = k
        long sum = 0L;
        int maxLength = 0;
        int i = 0;
        int k = 0;
        while (i < n) { // TC: O(N)
            sum += arr[i];
            long diff = sum - k;
            if (map.containsKey(diff)) {
                maxLength = Math.max(maxLength, i - map.get(diff));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            i++;
        }
        return maxLength;
    }
}
