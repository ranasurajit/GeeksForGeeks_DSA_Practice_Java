//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            int A = obj.minIncrements(a);
            System.out.println(A);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * TC: O(N x log(N) + N) ~ TC: O(N x log(N))
     * SC: O(1)
     */
    public int minIncrements(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);                // TC: O(N x log(N))
        int increments = 0;
        for (int i = 1; i < n; i++) {    // TC: O(N)
            int incrementNeeded = 0;
            if (arr[i] <= arr[i - 1]) {
                incrementNeeded = arr[i - 1] - arr[i] + 1;
            }
            arr[i] += incrementNeeded;
            increments += incrementNeeded;
        }
        return increments;
    }
}
