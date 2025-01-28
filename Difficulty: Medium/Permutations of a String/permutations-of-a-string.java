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
    public ArrayList<String> findPermutation(String s) {
        Set<String> result = new HashSet<String>();
        StringBuilder sb = new StringBuilder();
        solveSwap(0, s, sb, result);
        return new ArrayList<>(result);
    }
    
    /**
     * Approach II - Using Swapping
     * 
     * TC: O(N x N!)
     * SC: O(N)
     * 
     * @param s
     * @return
     */
    private void solveSwap(int idx, String s, StringBuilder sb, Set<String> result) {
        // base case when sb.length() = s.length()
        if (idx == s.length()) {
            result.add(s);
            return;
        }
        // we need to always begin from start index 0
        for (int i = idx; i < s.length(); i++) {
            // swap
            s = swap(s, i, idx);
            // explore
            solveSwap(idx + 1, s, sb, result);
            // backtrack
            s = swap(s, i, idx);
        }
    }
    
    private String swap(String s, int fromIndex, int toIndex) {
        char[] ch = s.toCharArray();
        char temp = ch[toIndex];
        ch[toIndex] = ch[fromIndex];
        ch[fromIndex] = temp;
        return String.valueOf(ch);
    }

    public ArrayList<String> findPermutationApproachI(String s) {
        Set<String> result = new HashSet<String>();
        Set<String> set = new HashSet<String>();
        StringBuilder sb = new StringBuilder();
        solve(s, sb, set, result);
        return new ArrayList<>(result);
    }
    
    /**
     * Approach I
     * 
     * TC: O(N x N!)
     * SC: O(N)
     * 
     * @param s
     * @return
     */
    private void solve(String s, StringBuilder sb, Set<String> set,
            Set<String> result) {
        // base case when sb.length() = s.length()
        if (sb.length() == s.length()) {
            result.add(sb.toString());
            return;
        }
        // we need to always begin from start index 0
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String key = ch + "-" + i;
            if (!set.contains(key)) {
                // choose option
                sb.append(ch);
                set.add(ch + "-" + i);
                // explore further
                solve(s, sb, set, result);
                // backtrack
                sb.setLength(sb.length() - 1);
                set.remove(ch + "-" + i);
            }
        }
    }
}
