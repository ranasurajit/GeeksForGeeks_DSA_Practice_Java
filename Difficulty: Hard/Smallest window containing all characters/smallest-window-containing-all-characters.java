class Solution {
    /**
     * Approach : Using Sliding Window (Variable Size) Approach
     * 
     * TC: O(M + N)
     * SC: O(26) ~ O(1)
     */
    public static String smallestWindow(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[] freq = new int[26]; // TC: O(26)
        int i = 0;
        for (i = 0; i < m; i++) { // TC: O(M)
            freq[p.charAt(i) - 'a']++;
        }
        i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        int minLength = n;
        int startIdx = -1;
        while (j < n) { // TC: O(N)
            freq[s.charAt(j) - 'a']--;
            while (i <= j && isZeroArray(freq)) { // TC: O(26)
                if (j - i + 1 < minLength) {
                    minLength = j - i + 1;
                    startIdx = i;
                }
                // remove computation from index 'i'
                freq[s.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }
        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLength);
    }

    /**
     * Using Simulation Approach
     * 
     * TC: O(26) ~ O(1)
     * SC: O(1)
     */
    private static boolean isZeroArray(int[] freq) {
        for (int i = 0; i < 26; i++) { // TC: O(26)
            if (freq[i] > 0) {
                // if freq[i] is > 0 that means all characters of p is not in this window 
                return false;
            }
        }
        return true;
    }
}
