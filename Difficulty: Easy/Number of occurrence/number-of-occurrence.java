//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countFreq(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Binary Search Approach
     * 
     * TC: O(2 x log(N)) ~ O(log(N))
     * SC: O(1)
     */
    int countFreq(int[] arr, int target) {
        int n = arr.length;
        int lBound = lowerBound(arr, target, n);
        if (lBound == n) {
            return 0;
        }
        int uBound = upperBound(arr, target, n);
        return uBound - lBound;
    }
    
    /**
     * Binary Search Approach
     * 
     * TC: O(log(N))
     * SC: O(1)
     */
    private int lowerBound(int[] arr, int target, int n) {
        int lbound = n;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    /**
     * Binary Search Approach
     * 
     * TC: O(log(N))
     * SC: O(1)
     */
    private int upperBound(int[] arr, int target, int n) {
        int lbound = n;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    /**
     * Brute-Force Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    int countFreqBruteForce(int[] arr, int target) {
        int count = 0;
        for (int it : arr) { // TC: O(N)
            if (it == target) {
                count++;
            }
        }
        return count;
    }
}
