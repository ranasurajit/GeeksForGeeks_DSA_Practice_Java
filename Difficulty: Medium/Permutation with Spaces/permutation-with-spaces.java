//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);

            for (int i = 0; i < ans.size(); i++) {
                System.out.print("(" + ans.get(i) + ")");
            }
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach : Using Recursion and Sorting
     * 
     * TC: O(N x 2 ^ N)
     * SC: O(N x 2 ^ N)
     */
    ArrayList<String> permutation(String s) {
        int n = s.length();
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder(); // SC: O(2 ^ N)
        solveRecursion(0, s, n, sb, result); // TC: O(2 ^ N), SC: O(N)
        Collections.sort(result); // TC: O(2 ^ N x log(2 ^ N)) ~ O(N x 2 ^ N)
        return result;
    }
    
    /**
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private void solveRecursion(int idx, String s, int n, StringBuilder current,
        ArrayList<String> result) {
        // Base Case
        if (idx == n) {
            if (current.charAt(current.length() - 1) != ' ') {
                result.add(current.toString());
            }
            return;
        }
        // Recursion Calls
        // not take space
        current.append(s.charAt(idx));
        solveRecursion(idx + 1, s, n, current, result);
        // take space
        current.append(' ');
        solveRecursion(idx + 1, s, n, current, result);
        // backtrack to explore all other possibilities
        current.setLength(current.length() - 2); // reverted both character and space
    }
}
