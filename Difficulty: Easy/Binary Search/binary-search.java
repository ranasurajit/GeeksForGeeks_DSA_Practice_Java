//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline
        while (t-- > 0) {
            int k = sc.nextInt();
            sc.nextLine(); // consume the newline
            String input = sc.nextLine();
            String[] strNumbers = input.split(" ");
            int[] arr = new int[strNumbers.length];
            for (int i = 0; i < strNumbers.length; i++) {
                arr[i] = Integer.parseInt(strNumbers[i]);
            }
            Solution ob = new Solution();
            int res = ob.binarysearch(arr, k);
            System.out.println(res);

            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    /**
     * Approach : Using Binary Search
     *
     * TC: O(log(N))
     * SC: O(1)
     */
    public int binarysearch(int[] arr, int k) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        int index = -1;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (arr[mid] == k) {
                index = mid;
                high = mid - 1;
                // shrink the search space to left in case there are multiple values = k
            } else if (arr[mid] < k) {
                // search space is after mid index
                low = mid + 1;
            } else {
                // search space is before mid index
                high = mid - 1;
            }
        }
        return index;
    }
}
