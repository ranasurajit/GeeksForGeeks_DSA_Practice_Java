//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_cases = Integer.parseInt(br.readLine().trim());

        while (test_cases-- > 0) {
            // Read the array from input line
            String[] input = br.readLine().trim().split(" ");
            int[] arr = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            // Solution instance to invoke the function
            Solution ob = new Solution();
            int result = ob.hIndex(arr);

            System.out.println(result);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to find hIndex
    /**
     * TC: O(N + N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     */
    public int hIndex(int[] citations) {
        int low = 0;
        int high = 0;
        for (int item : citations) {                       // TC: O(N)
            high = Math.max(high, item);
        }
        // Applying Binary Search
        int maxVal = 0;
        while (low <= high) {                              // TC: O(log(N))
            int mid = low + (high - low) / 2;
            int computedValue = getHIndex(citations, mid); // TC: O(N)
            if (computedValue >= mid) {
                maxVal = Math.max(maxVal, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return maxVal;
    }
    
    /**
     * TC: O(N)
     * SC: O(1)
     */
    private int getHIndex(int[] citations, int mid) {
        int count = 0;
        for (int item : citations) {
            if (item >= mid) {
                count++;
            }
        }
        return count;
    }
}
