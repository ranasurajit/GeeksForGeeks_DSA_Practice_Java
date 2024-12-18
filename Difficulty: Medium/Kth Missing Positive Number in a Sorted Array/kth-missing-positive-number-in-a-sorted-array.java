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
            int ans = sln.kthMissing(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Optimal Approach (Using Binary Search)
     * 
     * TC: O(log(N))
     * SC: O(1)
     */
    public int kthMissing(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low + k;
    }
    
    /**
     * Brute-Force Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int kthMissingBruteForce(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] <= k) {
                k++;
            } else {
                break;
            }
        }
        return k;
    }
}
