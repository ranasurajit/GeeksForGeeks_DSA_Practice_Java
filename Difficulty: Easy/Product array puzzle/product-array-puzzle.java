//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Using Array Pre-processing technique
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    public static int[] productExceptSelf(int arr[]) {
        int n = arr.length;
        int[] res = new int[n];
        // calculating suffixProduct from right to left
        int[] suffix = new int[n]; // SC: O(N)
        suffix[n - 1] = arr[n - 1] * 1;
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            suffix[i] = suffix[i + 1] * arr[i];
        }
        /**
         * now we will not create the prefixProduct to save
         * space complexity we will calculate on the fly
         * iterating from left to right
         */
        int prefix = 1;
        for (int i = 0; i < n ; i++) { // TC: O(N)
            if (i < n - 1) {
                res[i] = prefix * suffix[i + 1];
            } else {
                res[i] = prefix * 1;
            }
            // preparing for next iteration
            prefix = prefix * arr[i];
        }
        return res;
    }
}
