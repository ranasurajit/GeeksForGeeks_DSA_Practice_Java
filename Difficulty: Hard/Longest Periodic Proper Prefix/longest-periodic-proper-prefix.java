class Solution {
    /**
     * Approach II : Using Z-Algorithm (Optimal) Approach
     * 
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(N)
     * 
     * Accepted (1120 / 1120 test cases passed)
     */
    int getLongestPrefix(String s) {
        int n = s.length();
        int[] z = zFunction(s); // TC: O(N), SC: O(N)
        // traverse z-array to find position where
        // suffix equals prefix
        for (int i = n - 1 ; i > 0; i--) { // TC: O(N)
            if (z[i] == n - i) {
                // s[i:] is a suffix that is equal to 
                // the prefix of length n - i
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Using Z-Algorithm (Optimal) Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public static int[] zFunction(String s) {
        int n = s.length();
        int[] z = new int[n]; // SC: O(N)

        // [l, r] is the current segment that matches a prefix
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) { // TC: O(N)
            if (i <= r) {
                // inside the z-box: reuse previously computed values
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            // try to extend the match beyond the current z-box
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            // update the z-box if the match extended beyond
            // current right boundary
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        return z;
    }
    
    /**
     * Approach I : Using Simulation (Brute-Force) Approach
     * 
     * TC: O(N x 3 x N) ~ O(N ^ 2)
     * SC: O(2 x N) ~ O(N)
     * 
     * Time Limit Exceeded (1110 / 1120 test cases passed)
     */
    int getLongestPrefixBruteForce(String s) {
        int n = s.length();
        /**
         * prefix will range from size (1 to n - 1)
         */
        for (int i = n - 1; i >= 1; i--) { // TC: O(N)
            String prefix = s.substring(0, i); // TC: O(N), SC: O(N)
            while (prefix.length() < n) { // TC: O(N), SC: O(N)
                prefix += prefix;
            }
            if (prefix.startsWith(s)) { // TC: O(N)
                return i;
            }
        }
        return -1;
    }
}
