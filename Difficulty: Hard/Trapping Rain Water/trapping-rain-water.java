//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Using Two Pointers Approach
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * @param arr
     * @return
     */
    public int maxWater(int arr[]) {
        int n = arr.length;
        int i = 0; // left pointer
        int j = n - 1; // right pointer
        int leftMax = arr[0];
        int rightMax = arr[n - 1];
        int waterCollected = 0;

        while (i < j) { // TC: O(N)
            leftMax = Math.max(leftMax, arr[i]);
            rightMax = Math.max(rightMax, arr[j]);
            if (arr[i] < arr[j]) {
                waterCollected += leftMax - arr[i];
                i++;
            } else {
                waterCollected += rightMax - arr[j];
                j--;
            }
        }
        return waterCollected;
    }
    
    /**
     * Using Array Pre-processing Approach
     * 
     * TC: O(3 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     * 
     * @param arr
     * @return
     */
    public int maxWaterBruteForce(int arr[]) {
        int n = arr.length;
        /**
         * we need to calculate the maximum height of buildings
         * from either sides for an index
         */
        int[] leftMax = new int[n]; // SC: O(N)
        int[] rightMax = new int[n]; // SC: O(N)
        // left to right
        leftMax[0] = arr[0];
        for (int i = 1; i < rightMax.length; i++) { // TC: O(N)
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }
        // right to left
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }
        // water collected at any index = Min(leftMax[i], rightMax[i]) - height[i]
        int waterCollected = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            waterCollected += Math.min(leftMax[i], rightMax[i]) - arr[i];
        }
        return waterCollected;
    }
}
