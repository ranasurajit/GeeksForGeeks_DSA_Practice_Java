//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            ArrayList<Integer> result = ob.bracketNumbers(S);
            for (int value : result) out.print(value + " ");
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        Stack<Integer> openStack = new Stack<Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int open = 0;
        int close = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                open += 1;
                openStack.add(open);
                list.add(open);
            } else if (ch == ')') {
                list.add(openStack.pop());
            }
        }
        return list;
    }
}
