class Solution {
    /**
     * Approach : Using Rabin-Karp Algorithm Approach
     * 
     * TC: O(M + N)
     * SC: O(M)
     * 
     * worst case TC: O(M x N) if there are more spurious hits because of weak Hash function
     */
    public ArrayList<Integer> rabinKarp(String text, String pattern) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int m = pattern.length();
        int n = text.length();
        // Invalid case
        if (m > n) {
            return result;
        }
        /**
         * Hash function here will have a Base = 26
         * 
         * Base ^ (m - 1) x (pattern[0] - 'a') + Base ^ (m - 2) x (pattern[1] - 'a') +
         * ..... + Base ^ 0 x (pattern[m - 1] - 'a')
         */
        long base = 26L; // as we have all lowercase letters
        int mod = (int) 1e9 + 7;
        // pre-calculation powers for reducing complexity
        long[] powers = new long[m]; // SC: O(M)
        powers[0] = 1;
        for (int i = 1; i < m; i++) { // TC: O(M)
            powers[i] = (base * powers[i - 1]) % mod;
        }
        /**
         * we will find the HashValue of our String 'pattern' 
         * and [0 - (m - 1)] substring of String 'text'
         */
        long pHash = 0L;
        long tHash = 0L;
        for (int i = 0; i < m; i++) { // TC: O(M)
            pHash = (pHash * base + (pattern.charAt(i) - 'a')) % mod;
            tHash = (tHash * base + (text.charAt(i) - 'a')) % mod;
        }
        for (int i = 0; i < n - m + 1; i++) { // TC: O(N - M)
            if (pHash == tHash && isMatched(text, pattern, i, m, n)) { // TC: O(M)
                result.add(i);
            }
            if (i + m < n) {
                /**
                 * recalculating the tHash based on next upcoming index and 
                 * negating calculations from index 'i'
                 */
                long removed = (powers[m - 1] * (text.charAt(i) - 'a')) % mod;
                tHash = (tHash - removed + mod) % mod;
                tHash = ((tHash * base) % mod + (text.charAt(i + m) - 'a')) % mod;
            }
        }
        return result;
    }

    /**
     * Using Two Pointers Approach
     * 
     * TC: O(M)
     * SC: O(1)
     */
    private boolean isMatched(String text, String pattern, int start, int m, int n) {
        int p = 0; // start pointer of String 'pattern'
        int q = start;
        while (p < m && q < n) {
            if (pattern.charAt(p) != text.charAt(q)) {
                return false;
            }
            p++;
            q++;
        }
        return true;
    }
}
