//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach I : Using Two Pointers Approach
     * 
     * TC: O(M + N)
     * SC: O(1)
     */
    public long kthElement(int k, int arr1[], int arr2[]) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int p = 0;
        int q = 0;
        int r = 0;
        int kAnswer = 0;
        while (p < len1 && q < len2) {
            if (arr1[p] < arr2[q]) {
                kAnswer = arr1[p];
                p++;
            } else {
                kAnswer = arr2[q];
                q++;
            }
            if (r == k - 1) {
                return kAnswer;
            }
            r++;
        }
        while (p < len1) {
            kAnswer = arr1[p];
            if (r == k - 1) {
                return kAnswer;
            }
            p++;
            r++;
        }
        while (q < len2 && r <= k - 1) {
            kAnswer = arr2[q];
            if (r == k - 1) {
                return kAnswer;
            }
            q++;
            r++;
        }
        return kAnswer;
    }

    /**
     * Approach II : Using Binary Search Approach
     * 
     * TC: O(log(Min(N1, N2)))
     * SC: O(1)
     */
    public int kthElement(int a[], int b[], int k) {
        int n1 = a.length;
        int n2 = b.length;
        // ensure that array 'a' is the smaller array
        if (n1 > n2) {
            return kthElement(b, a, k);
        }
        // now array 'a' is the smallest array with size n1
        int low = Math.max(0, k - n2); // if k > n1 then we need atleast (k - n2) elements from 'b'
        int high = Math.min(k, n1); // cannot pick up more than k elements from 'a'
        // Applying Binary Search
        while (low <= high) { // TC: O(log(Min(N1, N2)))
            int mid1 = low + (high - low) / 2;
            // finding all the range values
            int mid2 = k - mid1;
            int l1 = mid1 > 0 ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = mid2 > 0 ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = mid1 < n1 ? a[mid1] : Integer.MAX_VALUE;
            int r2 = mid2 < n2 ? b[mid2] : Integer.MAX_VALUE;
            // Applying Binary Search conditions
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else if (l2 > r1) {
                low = mid1 + 1;
            }
        }
        return 0;
    }
}
