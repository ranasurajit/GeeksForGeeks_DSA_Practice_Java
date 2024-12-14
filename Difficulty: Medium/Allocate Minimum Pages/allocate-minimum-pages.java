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
     * Optimal Approach (Using Binary Search)
     * 
     * TC: O(N x log(K)), where K = Sum(arr) - Max(arr)
     * SC: O(1)
     */
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        if (n < k) {
            /* 
             * if number of books < number of students then it voilates 
             * the rule - Each student receives atleast one book.
             */
            return -1;
        }
        int low = 0;
        int high = 0;
        for (int item : arr) {
            low = Math.max(low, item);
            high += item;
        }
        // Using Binary search
        int result = 0;
        while (low <= high) { // TC: O(log(K))
            int mid = low + (high - low) / 2;
            if (wouldStudentsNotExceed(mid, arr, k, n)) { // TC: O(N)
                // decrease pages from student to adjust
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
    
    /**
     * TC: O(N)
     * SC: O(1)
     */
    private static boolean wouldStudentsNotExceed(int maxPages, int[] arr, int k, int n) {
        int numStudents = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > maxPages) {
                numStudents++;
                sum = arr[i];
            }
        }
        return numStudents <= k;
    }
}
