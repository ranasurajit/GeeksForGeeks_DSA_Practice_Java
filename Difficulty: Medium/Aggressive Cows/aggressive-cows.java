//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    /**
     * Optimal Approach - Using Binary Search
     * 
     * TC: O(N x log(K) + N x log(N))
     * SC: O(1)
     */
    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        // sort the stalls by position
        Arrays.sort(stalls);                   // TC: O(N x log(N))
        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        while (low <= high) {                  // TC: O(log(K))
            int mid = low + (high - low) / 2;
            if (canBePlaced(stalls, k, mid)) { // TC: O(N)
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }
    
    /**
     * Brute-Force Approach - Using Linear Search
     * 
     * TC: O(K x N + N x log(N))
     * SC: O(1)
     */
    public static int aggressiveCowsBruteForce(int[] stalls, int k) {
        int n = stalls.length;
        // sort the stalls by position
        Arrays.sort(stalls); // TC: O(N x log(N))
        int low = stalls[0];
        int high = stalls[n - 1];
        for (int i = 1; i <= (high - low); i++) { // TC: O(K), where K = Max(stalls) - Min(stalls)
            if (canBePlaced(stalls, k, i)) { // TC: O(N)
                continue;
            } else {
                return i - 1;
            }
        }
        return -1;
    }
    
    /**
     * TC: O(N)
     * SC: O(1)
     */
    private static boolean canBePlaced(int[] stalls, int cows, int dist) {
        int countCows = 1;
        int lastPos = stalls[0];
        for (int i = 1; i < stalls.length; i++) { // TC: O(N)
            if (stalls[i] - lastPos >= dist) {
                // cow can be placed at stalls[i]
                countCows++;
                lastPos = stalls[i];
            }
        }
        return countCows >= cows;
    }
}
