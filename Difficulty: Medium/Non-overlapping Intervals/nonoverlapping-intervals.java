//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[][] = new int[n][2];
            for (int i = 0; i < n; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minRemoval(a);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * TC: O(N + N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     */
    static int minRemoval(int intervals[][]) {
        int n = intervals.length;
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]); // TC: O(N x log(N))
        int count = 0;
        for (int i = 1; i < n; i++) {                              // TC: O(N)
            if (intervals[i][0] < intervals[i - 1][1]) {
                // overlapped
                /*
                 * setting the overlapped interval's end time to minimum value
                 * so that it does not again overlap with next interval
                 */
                intervals[i][1] = Math.min(intervals[i - 1][1], intervals[i][1]);
                count++;
            }
        }
        return count;
    }
}
