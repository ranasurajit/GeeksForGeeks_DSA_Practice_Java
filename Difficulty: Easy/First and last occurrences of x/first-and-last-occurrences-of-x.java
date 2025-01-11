//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            int x = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

            String inputLine1[] = br.readLine().trim().split(" ");
            int n = inputLine1.length;
            int arr[] = new int[(int)(n)];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine1[i]);
            }

            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.firstAndLast(x, arr);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    /**
     * Using Binary Search
     * 
     * TC: O(2 x log(N)) ~ O(log(N))
     * SC: O(1)
     */
    public ArrayList<Integer> firstAndLast(int x, int arr[]) {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        int minIndex = searchMinRange(arr, x);
        if (minIndex == -1) {
            indices.add(-1);
            return indices;
        }
        int maxIndex = searchMaxRange(arr, x);
        indices.add(minIndex);
        indices.add(maxIndex);
        return indices;
    }
    
    /**
     * TC: O(log(N))
     * SC: O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    private int searchMinRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int minRange = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                // nums[mid] = target
                minRange = mid;
                high = mid - 1;
            }
        }
        return minRange;
    }

    /**
     * TC: O(log(N))
     * SC: O(1)
     * 
     * @param nums
     * @param target
     * @return
     */
    private int searchMaxRange(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int maxRange = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                // nums[mid] = target
                maxRange = mid;
                low = mid + 1;
            }
        }
        return maxRange;
    }
}
