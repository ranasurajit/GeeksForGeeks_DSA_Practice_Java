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


// User function Template for Java

class Solution {
    /**
     * Using Two Pointers Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int maxWater(int arr[]) {
        int n = arr.length;
        int i = 0; // start pointer
        int j = n - 1; // end pointer
        int leftMax = arr[0];
        int rightMax = arr[n - 1];
        int current = 0;
        int max = 0;
        while (i < j) { // TC: O(N)
            if (arr[i] < arr[j]) {
                current = arr[i] * (j - i);
                i++;
            } else {
                current = arr[j] * (j - i);
                j--;
            }
            max = Math.max(max, current);
        }
        return max;
    }
}
