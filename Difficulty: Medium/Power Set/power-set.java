//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach : Using Recursion Approach
     *
     * TC: O(2 ^ N + 2 ^ N x log(2 ^ N)) ~ O(N x 2 ^ N)
     * SC: O(2 ^ N + N) ~ O(2 ^ N)
     */
    public List<String> AllPossibleStrings(String s) {
        List<String> result = new ArrayList<String>(); // SC: O(2 ^ N)
        StringBuilder sb = new StringBuilder();
        solveRecursion(0, s, sb, result); // TC: O(2 ^ N), SC: O(N)
        Collections.sort(result); // TC: O(M x log(M)), where M = (2 ^ N - 1) ~ (2 ^ N)
        return result;
    }

    /**
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private void solveRecursion(int idx, String s, StringBuilder current, List<String> result) {
        // Base Case
        if (idx == s.length()) {
            if (current.length() > 0) {
                result.add(current.toString());
            }
            return;
        }
        // Recursion Calls
        // not take
        solveRecursion(idx + 1, s, current, result); // Hypothesis
        // take
        current.append(s.charAt(idx)); // Induction
        solveRecursion(idx + 1, s, current, result); // Hypothesis
        // backtrack to explore other possibilities
        current.setLength(current.length() - 1);
    }
}
