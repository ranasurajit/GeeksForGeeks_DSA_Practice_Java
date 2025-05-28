//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<String> ans = obj.findPermutation(S);
            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++) {
                out.print(ans.get(i) + " ");
            }
            out.println();

            out.println("~");
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    /**
     * Approach II : Using Recursion + Backtracking (Optimal) Approach
     * 
     * TC: O(N x N!)
     * SC: O(N x N! + 2 x N) ~ O(N x N!)
     * 
     * Accepted (Test Cases Passed: 1026 /1026)
     */
    public ArrayList<String> findPermutation(String s) {
        Set<String> resultSet = new HashSet<String>(); // SC: O(N)
        Set<String> used = new HashSet<String>(); // SC: O(N)
        backtrack(0, s.toCharArray(), used, resultSet); // TC: O(N x N!), SC: O(N x N! + N)
        return new ArrayList<String>(resultSet);
    }

    /**
     * Using Recursion + Backtracking Approach
     * 
     * TC: O(N x N!)
     * SC: O(N x N! + N)
     */
    private void backtrack(int index, char[] chars, Set<String> used, Set<String> resultSet) {
        // Base Case
        if (index == chars.length) {
            resultSet.add(String.valueOf(chars));
            return;
        }
        // Recursion Calls
        for (int i = index; i < chars.length; i++) { // TC: O(N)
            String key = chars[index] + "-" + index;
            if (!used.contains(key)) {
                used.add(key);
                // swap the character at index with character at i
                swap(chars, index, i);
                backtrack(index + 1, chars, used, resultSet);
                // backtrack
                swap(chars, index, i); // undo the swap operation to explore other possibilities
                used.remove(key);
            }
        }
    }

    /**
     * Swapping Approach
     * 
     * TC: O(1)
     * SC: O(1)
     */
    private void swap(char[] chars, int a, int b) {
        char temp = chars[b];
        chars[b] = chars[a];
        chars[a] = temp;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(N x N!)
     * SC: O(N x N! + 4 x N) ~ O(N x N!)
     * 
     * Time limit exceeded (Test Cases Passed: 1015 /1026)
     */
    public ArrayList<String> findPermutationApproachI(String s) {
        Set<String> resultSet = new HashSet<String>(); // SC: O(N)
        Set<String> used = new HashSet<String>(); // SC: O(N)
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        solveRecursion(s, sb, resultSet, used); // TC: O(N x N!), SC: O(N x N! + N)
        return new ArrayList<String>(resultSet);
    }

    /**
     * Using Recursion Approach
     * 
     * TC: O(N x N!)
     * SC: O(N x N! + N)
     */
    private void solveRecursion(String s, StringBuilder sb, Set<String> resultSet,
            Set<String> used) {
        // Base Case
        if (sb.length() == s.length()) {
            resultSet.add(sb.toString());
            return;
        }
        // Recursion Calls
        for (int i = 0; i < s.length(); i++) { // TC: O(N)
            char ch = s.charAt(i);
            String key = ch + "-" + i;
            if (!used.contains(key)) {
                used.add(key);
                sb.append(ch);
                solveRecursion(s, sb, resultSet, used);
                // backtrack sb and used to explore other paths/choices
                sb.setLength(sb.length() - 1);
                used.remove(key);
            }
        }
    }
}
