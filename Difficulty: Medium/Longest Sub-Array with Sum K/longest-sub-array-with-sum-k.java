//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);

            int arr[] = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution obj = new Solution();
            int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    /**
     * TC: O(N)
     * SC: O(N)
     */
    public static int lenOfLongSubarr(int A[], int N, int K) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // SC: O(N)
        hm.put(0, -1);
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) { // TC: O(N)
            sum += A[i];
            int diff = sum - K;
            if (hm.containsKey(diff)) {
                max = Math.max(max, i - hm.get(diff));
            }
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
