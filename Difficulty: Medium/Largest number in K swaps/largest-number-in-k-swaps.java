//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            String str = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.findMaximumNum(str, k));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to find the largest number after k swaps.
    /**
     * Approach : Using Recursion and Backtracking Approach
     * 
     * TC: O(K x N ^ 2)
     * SC: O(K)
     */
    public String findMaximumNum(String s, int k) {
        int n = s.length();
        String[] max = { s };
        Set<String> visited = new HashSet<String>();
        solve(s.toCharArray(), n, k, max, visited);
        return max[0];
    }
    
    /**
     * TC: O(K x N ^ 2)
     * SC: O(K)
     */
    private void solve(char[] s, int n, int k, String[] max, Set<String> visited) {
        String current = new String(s);
        if (current.compareTo(max[0]) > 0) {
            max[0] = current;
        }
        // Base Case
        if (k == 0) {
            return;
        }
        String key = new String(s) + "_" + k;
        if (visited.contains(key)) {
            return;
        }
        visited.add(key);
        // Recursion Calls
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (s[i] < s[j]) {
                    swap(s, i, j); // TC: O(1)
                    solve(s, n, k - 1, max, visited);
                    swap(s, i, j); // backtrack - TC: O(1)
                }
            }
        }
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private void swap(char[] s, int i, int j) {
        char temp = s[j];
        s[j] = s[i];
        s[i] = temp;
    }
}
