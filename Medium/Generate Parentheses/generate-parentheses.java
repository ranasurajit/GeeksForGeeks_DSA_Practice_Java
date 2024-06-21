//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        generateParentheses(sb, 0, 0, n, list);
        return list;
    }
    
    private void generateParentheses(StringBuilder sb, int open, int close, int n, List<String> list) {
        // Base condition
        if (open == n && close == n) {
            // checking if pairs i.e. open == close == n
            list.add(sb.toString());
            return;
        }
        if (open < n) {
            generateParentheses(sb.append("("), open + 1, close, n, list);
            sb.setLength(sb.length() - 1);
        }
        if (open > close) {
            generateParentheses(sb.append(")"), open, close + 1, n, list);
            sb.setLength(sb.length() - 1);
        }
    }
}
