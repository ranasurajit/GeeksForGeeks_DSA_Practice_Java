//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            String line = sc.nextLine();
            String[] dictionary = line.split(" ");

            Solution obj = new Solution();
            if (obj.wordBreak(s, dictionary)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    TrieNode root;

    /**
     * Approach V : Using Memoization With Trie Approach
     * 
     * TC: O((N x N) + (T x K))
     * SC: O(T x N)
     * 
     * where T = number of words in 'dictionary'
     *       K = average length of words in 'dictionary'
     */
    public boolean wordBreak(String s, String[] dictionary) {
        root = new TrieNode(); // TC: O(T x N)
        for (String word : dictionary) { // TC: O(T)
            TrieNode crawl = root;
            for (char ch : word.toCharArray()) { // TC: O(K)
                int idx = ch - 'a';
                if (crawl.children[idx] == null) {
                    crawl.children[idx] = new TrieNode();
                }
                crawl = crawl.children[idx];
            }
            crawl.isEnd = true;
        }
        Boolean[] dp = new Boolean[s.length() + 1];
        return solveTrieMemoization(0, s, dp); // TC: O(N x N), SC: O(N)
    }
    
    /**
     * Using Memoization
     * 
     * TC: O(N x N)
     * SC: O(N)
     */
    private boolean solveTrieMemoization(int idx, String s, Boolean[] dp) {
        // Base Case
        if (idx >= s.length()) {
            return true;
        }
        // Memoization Check
        if (dp[idx] != null) {
            return dp[idx];
        }
        // Recursion Calls
        TrieNode crawl = root;
        for (int endIdx = idx; endIdx < s.length(); endIdx++) {
            if (crawl.children[s.charAt(endIdx) - 'a'] == null) {
                break;
            }
            crawl = crawl.children[s.charAt(endIdx) - 'a'];
            if (crawl.isEnd && solveTrieMemoization(endIdx + 1, s, dp)) {
                return dp[idx] = true;
            }
        }
        return dp[idx] = false;
    }

    /**
     * Approach IV : Using Recursion With Trie Approach
     * 
     * TC: O((N x 2 ^ N) + (T x K))
     * SC: O(T x N)
     * 
     * where T = number of words in 'dictionary'
     *       K = average length of words in 'dictionary'
     */
    public boolean wordBreakTrieRecursion(String s, String[] dictionary) {
        root = new TrieNode(); // TC: O(T x N)
        for (String word : dictionary) { // TC: O(T)
            TrieNode crawl = root;
            for (char ch : word.toCharArray()) { // TC: O(K)
                int idx = ch - 'a';
                if (crawl.children[idx] == null) {
                    crawl.children[idx] = new TrieNode();
                }
                crawl = crawl.children[idx];
            }
            crawl.isEnd = true;
        }
        return solveTrieRecursion(0, s); // TC: O(N x 2 ^ N), SC: O(N)
    }
    
    /**
     * Using Recursion
     * 
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    private boolean solveTrieRecursion(int idx, String s) {
        // Base Case
        if (idx >= s.length()) {
            return true;
        }
        // Recursion Calls
        TrieNode crawl = root;
        for (int endIdx = idx; endIdx < s.length(); endIdx++) {
            if (crawl.children[s.charAt(endIdx) - 'a'] == null) {
                break;
            }
            crawl = crawl.children[s.charAt(endIdx) - 'a'];
            if (crawl.isEnd && solveTrieRecursion(endIdx + 1, s)) {
                return true;
            }
        }
        return false;
    }
    
    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        
        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    /**
     * Approach III : Using Tabulation Approach
     * 
     * TC: O(N x N)
     * SC: O(N x N)
     * 
     * where T = number of words in 'dictionary'
     */
    public boolean wordBreakTabulation(String s, String[] dictionary) {
        int n = s.length();
        Set<String> dict = new HashSet<String>(); // SC: O(T)
        for (String d : dictionary) { // TC: O(T)
            dict.add(d);
        }
        // Initialization
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // Iterative Calls
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = dp[i] || (dp[i - j] && dict.contains(s.substring(i - j, i)));
            }
        }
        return dp[n];
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordDict);
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length ; i++) {
            for (int k = 1; k <= i; k++) {
                dp[i] = dp[i] || (dp[i - k] && wordSet.contains(s.substring(i - k, i)));
            }
        }
        return dp[s.length()];
    }
    

    /**
     * Approach II : Using Memoization Approach
     * 
     * TC: O(N x N)
     * SC: O(N x N + N)
     * 
     * where T = number of words in 'dictionary'
     */
    public boolean wordBreakMemoization(String s, String[] dictionary) {
        Set<String> dict = new HashSet<String>(); // SC: O(T)
        for (String d : dictionary) { // TC: O(T)
            dict.add(d);
        }
        Boolean[] memo = new Boolean[s.length() + 1];
        return solveMemoization(s, dict, 0, memo);
    }
    
    /**
     * Using Memoization Approach
     * 
     * TC: O(N x N)
     * SC: O(N x N)
     */
    private boolean solveMemoization(String s, Set<String> dict, int idx, Boolean[] memo) {
        // Base Case
        if (idx == s.length()) {
            return true;
        }
        // Memoization Check
        if (memo[idx] != null) {
            return memo[idx];
        }
        // Recursion Calls
        for (int endIdx = idx + 1; endIdx <= s.length(); endIdx++) {
            if (dict.contains(s.substring(idx, endIdx)) &&
                solveMemoization(s, dict, endIdx, memo)) {
                return memo[idx] = true;
            }
        }
        return memo[idx] = false;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(T + N x 2 ^ N)
     * SC: O(N + T)
     * 
     * where T = number of words in 'dictionary'
     */
    public boolean wordBreakRecursion(String s, String[] dictionary) {
        Set<String> dict = new HashSet<String>(); // SC: O(T)
        for (String d : dictionary) { // TC: O(T)
            dict.add(d);
        }
        return solveRecursion(s, dict, 0);
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    private boolean solveRecursion(String s, Set<String> dict, int idx) {
        // Base Case
        if (idx == s.length()) {
            return true;
        }
        // Recursion Calls
        for (int endIdx = idx + 1; endIdx <= s.length(); endIdx++) {
            if (dict.contains(s.substring(idx, endIdx)) && solveRecursion(s, dict, endIdx)) {
                return true;
            }
        }
        return false;
    }
}
