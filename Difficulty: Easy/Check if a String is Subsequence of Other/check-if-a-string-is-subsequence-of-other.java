class Solution {
    /**
     * Approach : Using Two Pointers Approach
     * 
     * TC: O(M) ~ O(length(s1))
     * SC: O(1)
     */
    public boolean isSubSeq(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int p = 0; // pointer at the start of String s1
        int q = 0; // pointer at the start of String s2
        while (p < m && q < n) { // TC: O(M)
            if (s1.charAt(p) == s2.charAt(q)) {
                p++;
                q++;
            } else {
                q++;
            }
        }
        return p == m;
    }
};
