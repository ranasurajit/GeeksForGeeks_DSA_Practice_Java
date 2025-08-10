class Solution {
    /**
     * Approach : Using Two Pointers Approach
     * 
     * TC: O(N x N) + O(N x N) ~ O(N x N)
     * SC: O(1)
     */
    public int countPS(String s) {
        int n = s.length();
        int oddCount = 0; // count of odd length palindrome sub-strings
        int evenCount = 0; // count of even length palindrome sub-strings
        /**
         * For each index either for odd/even length palindromes
         * we will expand the length so to check if we got a palindrome
         * or not
         */
        // counting odd length sub-string
        for (int i = 1; i < n; i++) { // TC: O(N)
            oddCount += countPalindromes(s, n, i - 1, i + 1); // TC: O(N)
        }
        // counting even length sub-string
        for (int i = 1; i < n; i++) { // TC: O(N)
            evenCount += countPalindromes(s, n, i - 1, i); // TC: O(N)
        }
        return oddCount + evenCount;
    }
    
    /**
     * Using Two Pointers Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private int countPalindromes(String s, int n, int p, int q) {
        int count = 0;
        while (p >= 0 && q < n) {
            if (s.charAt(p) == s.charAt(q)) {
                count++;
                p--;
                q++;
            } else {
                break;
            }
        }
        return count;
    }
}
