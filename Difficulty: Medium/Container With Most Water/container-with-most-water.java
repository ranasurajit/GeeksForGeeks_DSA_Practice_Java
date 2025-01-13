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
     * 
     * @param arr
     * @return
     */
    public int maxWater(int arr[]) {
        int n = arr.length;
        int i = 0; // start pointer
        int j = n - 1; // end pointer
        int max = 0;
        int current = 0;
        while (i < j) { // TC: O(N)
            if (arr[i] < arr[j]) {
                current = (j - i) * arr[i];
                i++;
            } else {
                current = (j - i) * arr[j];
                j--;
            }
            max = Math.max(max, current);
        }
        return max;
    }
}
