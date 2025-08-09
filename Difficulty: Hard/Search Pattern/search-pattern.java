class Solution {
    /**
     * Approach : Using KMP Algorithm Approach
     * 
     * TC: O(M + N)
     * SC: O(N)
     */
    ArrayList<Integer> search(String pat, String txt) {
        int m = txt.length();
        int n = pat.length();
        if (m < n) {
            return new ArrayList<Integer>();
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] lps = computeLPS(pat, n); // TC: O(N), SC: O(N)
        // we will now use Two Pointers Approach to search String 'pat' in 'txt'
        int i = 0; // pointer at the start of String 'txt'
        int j = 0; // pointer at the start of String 'pat'
        int startIdx = -1;
        while (i < m) { // TC: O(M)
            if (i < m && txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == n) {
                // we found a match
                result.add(i - j);
                j = lps[j - 1];
            }
            if (i < m && txt.charAt(i) != pat.charAt(j)) {
                // we will set j to fallback to lps[j - 1]
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    // if j = 0 already then we increment i
                    i++;
                }
            }
        }
        return result;
    }

    /**
     * Using KMP Algorithm Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    private int[] computeLPS(String pat, int n) {
        int[] lps = new int[n]; // SC: O(N)
        int len = 0;
        int i = 1;
        while (i < n) { // TC: O(N)
            if (pat.charAt(len) == pat.charAt(i)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                // we need to update the len to fallback to its previous index lps
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    i++;
                }
            }
        }
        return lps;
    }
}
