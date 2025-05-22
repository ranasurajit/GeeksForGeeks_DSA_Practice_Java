class Solution {
    /**
     * Approach II : Using Memoization Approach
     * 
     * TC: O(4 ^ N + N) ~ O(4 ^ N)
     * SC: O(2 x N) ~ O(N)
     */
    static int minDeletions(String s) {
        int n = s.length();
        /**
         * we can find the characters which can form the longest palindrome
         * so the question is reduced to finding length of longest common subsequence
         */
        String p = reverse(s); // TC: O(N)
        int[][] memo = new int[n + 1][n + 1];
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        int lcsLength = lcsMemoization(s, p, n, n, memo); // TC: O(4 ^ N), SC: O(N)
        return n - lcsLength;
    }
    
    /**
     * Using Memoization Approach
     * 
     * TC: O(2 ^ (M + N)) ~ O(4 ^ N)
     * SC: O(M + N) ~ O(2 x N) ~ O(N)
     * 
     * as M = N
     */
    private static int lcsMemoization(String s1, String s2, int m, int n, int[][] memo) {
        // Base Case
        if (m == 0 || n == 0) {
            return 0;
        }
        // Memoization Check
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        // Recursion Calls
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return memo[m][n] = 1 + lcsMemoization(s1, s2, m - 1, n - 1, memo);
        } else {
            return memo[m][n] = Math.max(lcsMemoization(s1, s2, m - 1, n, memo), 
            lcsMemoization(s1, s2, m, n - 1, memo));
        }
    }
    
    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(4 ^ N + N) ~ O(4 ^ N)
     * SC: O(2 x N) ~ O(N)
     */
    static int minDeletionsRecursion(String s) {
        int n = s.length();
        /**
         * we can find the characters which can form the longest palindrome
         * so the question is reduced to finding length of longest common subsequence
         */
        String p = reverse(s); // TC: O(N)
        int lcsLength = lcsRecursion(s, p, n, n); // TC: O(4 ^ N), SC: O(N)
        return n - lcsLength;
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(2 ^ (M + N)) ~ O(4 ^ N)
     * SC: O(M + N) ~ O(2 x N) ~ O(N)
     * 
     * as M = N
     */
    private static int lcsRecursion(String s1, String s2, int m, int n) {
        // Base Case
        if (m == 0 || n == 0) {
            return 0;
        }
        // Recursion Calls
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            return 1 + lcsRecursion(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(lcsRecursion(s1, s2, m - 1, n), lcsRecursion(s1, s2, m, n - 1));
        }
    }
    
    /**
     * Using Two Pointers Approach
     * 
     * TC: O(N / 2) ~ O(N)
     * SC: O(1)
     */
    private static String reverse(String s) {
        char[] ch = s.toCharArray();
        int start = 0;
        int end = ch.length - 1;
        while (start < end) {
            // swap
            char temp = ch[end];
            ch[end] = ch[start];
            ch[start] = temp;
            start++;
            end--;
        }
        return String.valueOf(ch);
    }
}
