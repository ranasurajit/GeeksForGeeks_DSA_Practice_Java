//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Using Binary Search Approach
     * 
     * TC: O(M x log(N))
     * SC: O(1)
     * 
     * @param arr
     * @return
     */
    public int rowWithMax1s(int arr[][]) {
        int maxIndex = -1;
        int m = arr.length;
        int n = arr[0].length;
        int currentCount = 0;
        int maxCount = 0;
        for (int i = 0; i < m; i++) { // TC: O(M)
            int lBound = lowerBound(arr[i], n, 1); // TC: O(log(N))
            if (lBound == n) {
                continue;
            }
            int uBound = upperBound(arr[i], n, 1); // TC: O(log(N))
            currentCount = uBound - lBound;
            if (maxCount < currentCount) {
                maxCount = currentCount;
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    /**
     * TC: O(log(N))
     * SC: O(1)
     * 
     * @param row
     * @param n
     * @param x
     * @return
     */
    private int lowerBound(int[] row, int n, int x) {
        int low = 0;
        int high = n - 1;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (row[mid] >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * TC: O(log(N))
     * SC: O(1)
     * 
     * @param row
     * @param n
     * @param x
     * @return
     */
    private int upperBound(int[] row, int n, int x) {
        int low = 0;
        int high = n - 1;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (row[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
