//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    /**
     * TC: O(2 x log(N)) ~ O(log(N))
     * SC: O(1)
     */
    int count(int[] arr, int n, int x) {
        // check if x is out of range of array 'arr'
        if (x < arr[0] || x > arr[n - 1]) {
            return 0;
        }
        int low = 0;
        int high = n - 1;
        int minIndex = Integer.MAX_VALUE;
        // TC: O(log(N))
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
                minIndex = Math.min(minIndex, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (minIndex == Integer.MAX_VALUE) {
            return 0;
        }
        low = 0;
        high = n - 1;
        int maxIndex = Integer.MIN_VALUE;
        // TC: O(log(N))
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                maxIndex = Math.max(maxIndex, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return maxIndex - minIndex + 1;
    }
}
