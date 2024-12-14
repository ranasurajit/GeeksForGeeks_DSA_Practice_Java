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
            int idx = obj.peakElement(a);
            int n = a.length;
            if (idx < 0 && idx >= n)
                System.out.println("false");
            else {
                if (n == 1 && idx == 0)
                    f = 1;
                else if (idx == 0 && a[0] > a[1])
                    f = 1;
                else if (idx == n - 1 && a[n - 1] > a[n - 2])
                    f = 1;
                else if (idx > 0 && idx < n && a[idx] > a[idx + 1] &&
                         a[idx] > a[idx - 1])
                    f = 1;
                else
                    f = 0;
                if (f == 1) {
                    System.out.println("true");
                } else {
                    System.out.println("false");
                }
            }
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
    public int peakElement(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        if (arr[0] > arr[1]) {
            return 0;
        }
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }
        int low = 1;
        int high = n - 2;
        while (low <= high) {     // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                // peak is at mid index
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                // mid index is at increasing curve and peak is at right
                low = mid + 1;
            } else if (arr[mid] < arr[mid - 1]) {
                // mid index is at decreasing curve and peak is at left
                high = mid - 1;
            }
        }
        return -1;
    }
    
    /**
     * Brute-Force Better Approach (Using Linear Search)
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int peakElementBruteForceBetter(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if ((i == 0 || arr[i - 1] < arr[i]) && (i == n - 1) || arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Brute-Force Approach (Using Linear Search)
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int peakElementBruteForce(int[] arr) {
        int n = arr.length;
        int peakIndex = 0;
        if (n == 1) {
            return 0;
        }
        if (arr[0] > arr[1]) {
            return 0;
        }
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;
        }
        for (int i = 1; i < n - 1; i++) { // TC: O(N)
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
