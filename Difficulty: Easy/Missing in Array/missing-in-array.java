//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(n, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    /**
     * Approach : Using Bit-Manipulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    int missingNum(int arr[]) {
        int n = arr.length;
        int xorMissing = 0;
        int xorAll = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            xorMissing ^= arr[i];
            xorAll ^= (i + 1);
        }
        xorAll ^= (n + 1);
        return xorMissing ^ xorAll;
    }
}

