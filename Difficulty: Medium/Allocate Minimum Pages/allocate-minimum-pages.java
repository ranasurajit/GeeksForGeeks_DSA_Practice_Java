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
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    /**
     * Optimal Approach (Binary Search)
     * 
     * TC: O(N + N x log(K)) ~ O(N x log(K)), where K = Sum(arr) - Max(arr)
     * SC: O(1)
     */
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        if (k > n) {
            // violates - Each student receives atleast one book
            return -1;
        }
        int low = 0;
        int high = 0;
        for (int pages : arr) { // TC: O(N)
            low = Math.max(low, pages);
            high += pages;
        }
        int minPages = Integer.MAX_VALUE;
        while (low <= high) { // TC: O(log(K))
            int mid = low + (high - low) / 2;
            int allocated = allocatedStudents(mid, arr, n); // TC: O(N)
            if (allocated <= k) {
                minPages = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minPages;
    }
    
    /**
     * Brute-Force Approach (Linear Search)
     * 
     * TC: O(N + K x N) ~ O(K x N), where K = Sum(arr) - Max(arr)
     * SC: O(1)
     */
    public static int findPagesBruteForce(int[] arr, int k) {
        int n = arr.length;
        if (k > n) {
            // violates - Each student receives atleast one book
            return -1;
        }
        int low = 0;
        int high = 0;
        for (int pages : arr) { // TC: O(N)
            low = Math.max(low, pages);
            high += pages;
        }
        for (int i = low; i <= high; i++) { // TC: O(K)
            if (allocatedStudents(i, arr, n) <= k) { // TC: O(N)
                return i;
            }
        }
        return -1;
    }
    
    /**
     * TC: O(N)
     * SC: O(1)
     */
    private static int allocatedStudents(int allocation, int[] arr, int n) {
        int students = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            sum += arr[i];
            if (sum > allocation) {
                students++;
                sum = arr[i];
            }
        }
        return students;
    }
}
