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
     * Using Array Pre-processing
     * 
     * TC: O(3 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public int maxWater(int arr[]) {
        int n = arr.length;
        int[] prefix = new int[n];         // SC: O(N)
        int[] suffix = new int[n];         // SC: O(N)
        
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {      // TC: O(N)
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
        
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }
        
        int water = 0;
        for (int i = 0; i < n; i++) {      // TC: O(N)
            water += Math.min(prefix[i], suffix[i]) - arr[i];
        }
        return water;
    }
}
