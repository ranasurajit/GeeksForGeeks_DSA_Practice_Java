//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine())
                               .trim()
                               .split(" "); // Read the input for the current test case
            int arr[] = new int[str.length];
            // Convert input string into an integer array
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Call the solution method and print the result
            System.out.println(new Solution().lis(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Using Binary Search Approach
     * Find index such that list.get(index) >= x
     * 
     * TC: O(N x log(K))
     * SC: O(N)
     */
    static int lis(int arr[]) {
        int n = arr.length;
        List<Integer> list = new ArrayList<Integer>(); // SC: O(N)
        list.add(arr[0]);
        for (int i = 1; i < n; i++) { // TC: O(N)
            if (arr[i] > list.get(list.size() - 1)) {
                list.add(arr[i]);
            } else {
                int idx = lowerBound(list, n, arr[i]);
                list.set(idx, arr[i]); // TC: O(log(K))
            }
        }
        return list.size();
    }

    /**
     * Using Binary Search Approach
     * Find index such that list.get(index) >= x
     * 
     * TC: O(log(K))
     * SC: O(1)
     */
    private static int lowerBound(List<Integer> list, int n, int x) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) >= x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
