//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    /**
     * Using Sliding Window + Two Pointers Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */ 
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = arr.length;
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        long sum = 0L;
        int length = -1;
        while (j < n) {           // TC: O(N)
            sum += arr[j];
            while (sum > target) {
                sum -= arr[i];
                i++;
            }
            if (sum == target) {
                length = j - i + 1;
                break;
            }
            j++;
        }
        if (length == -1) {
            result.add(-1);
            return result;
        }
        result.add(i + 1);
        result.add(i + length);
        return result;
    }
}
