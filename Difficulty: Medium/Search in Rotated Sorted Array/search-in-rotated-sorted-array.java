//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Using Binary Search
     * 
     * Intuition - To shrink the search space by finding 
     * the sorted portion of the rotated sorted array
     * 
     * TC: O(log(N))
     * SC: O(1)
     */
    int search(int[] arr, int key) {
        int n = arr.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {                // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[low] <= arr[mid]) {
                // left part is sorted
                if (arr[low] <= key && key <= arr[mid]) {
                    // key is probably present here so shrink the high
                    high = mid - 1;
                } else {
                    // key is not present in left part so shrink the low
                    low = mid + 1;
                }
            } else {
                // right part is sorted
                if (arr[mid] <= key && key <= arr[high]) {
                    // key is probably present here so shrink the low
                    low = mid + 1;
                } else {
                    // k is not present in right part so shrink the high
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
