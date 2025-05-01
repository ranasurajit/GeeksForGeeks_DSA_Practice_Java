//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findMaximum(arr);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach : Using Simulation
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int findMaximum(int[] arr) {
        int n = arr.length;
        int idx = -1;
        for (int i = 1; i < n - 1; i++) { // TC: O(N)
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            if (arr[0] > arr[1]) {
                return arr[0];
            } else if (arr[n - 1] > arr[n - 2]) {
                return arr[n - 1];
            }
        }
        return arr[idx];
    }
}
