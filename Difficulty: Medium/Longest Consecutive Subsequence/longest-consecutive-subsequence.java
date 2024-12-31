//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read first array
            String input = br.readLine();
            String[] inputArray = input.split(" ");
            int[] arr = Arrays.stream(inputArray).mapToInt(Integer::parseInt).toArray();

            Solution ob = new Solution();
            int res = ob.longestConsecutive(arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return length of longest subsequence of consecutive integers.
    /**
     * TC: O(N + Max(arr))
     * SC: O(10^5)
     */
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        int[] freq = new int[100002];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            freq[arr[i]]++;
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        for (int i = min; i <= max; i++) { // TC: O(Max(arr))
            if (freq[i] > 0) {
                count++;
            } else {
                // reset count here
                count = 0;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
