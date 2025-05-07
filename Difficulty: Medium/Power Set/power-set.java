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
     * TC: O(2 ^ N + M x log(M)) ~ O(2 ^ N)
     * SC: O(N)
     */
    public List<String> AllPossibleStrings(String s) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        solveRecursion(s, 0, sb, result); // TC: O(2 ^ N)
        Collections.sort(result); // TC: O(M x log(M))
        return result;
    }

    /**
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private void solveRecursion(String s, int idx, StringBuilder current, List<String> result) {
        // Base Case
        if (idx == s.length()) {
            if (current.length() > 0) {
                result.add(current.toString());
            }
            return;
        }
        // Recursion Calls
        // not take
        solveRecursion(s, idx + 1, current, result);
        // take
        current.append(s.charAt(idx));
        solveRecursion(s, idx + 1, current, result);
        // backtrack
        current.setLength(current.length() - 1);
    }
}
