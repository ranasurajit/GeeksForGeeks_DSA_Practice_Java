//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            System.out.println(ob.countAndSay(n));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Approach : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    public String countAndSay(int n) {
        // Base Case
        if (n == 1) {
            return "1";
        }
        // Hypothesis
        String prev = countAndSay(n - 1);
        // Induction
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < prev.length(); i++) {
            int count = 1;
            char current = prev.charAt(i);
            while (i < prev.length() - 1 && prev.charAt(i) == prev.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(current);
        }
        return sb.toString();
    }
}
