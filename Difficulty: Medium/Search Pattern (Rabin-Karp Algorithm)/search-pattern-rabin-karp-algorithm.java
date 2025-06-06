class Solution {
    private static final int MOD = (int) 1e9 + 7;
    private static final int BASE = 256; // for full ASCII characters
    
    /**
     * Approach : Using Rabin-Karp Algorithm Approach
     * 
     * TC: O(M + N)
     * SC: O(1)
     * 
     * worst case time complexity is still O(M x N) for more Spurious Hits
     * 
     * Spurious Hits - when Hash matches but not Strings
     */
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> indices = new ArrayList<Integer>();
        int m = pat.length();
        int n = txt.length();
        
        if (n < m) {
            return indices;
        }

        int power = 1;
        for (int i = 1; i < m; i++) { // TC: O(M)
            power = (BASE * power) % MOD;
        }
        int patHash = 0;
        int txtHash = 0;

        for (int i = 0; i < m; i++) { // TC: O(M)
            patHash = (BASE * patHash + (pat.charAt(i) - 'a')) % MOD;
            txtHash = (BASE * txtHash + (txt.charAt(i) - 'a')) % MOD;
        }

        for (int i = 0; i < n - m + 1; i++) { // TC: O(N - M)
            if (patHash == txtHash && pat.equals(txt.substring(i, i + m))) {
                indices.add(i + 1);
            }
            // update the txtHash foe next window
            if (i < n - m) {
                txtHash = (txtHash - (power * (txt.charAt(i) - 'a')) % MOD + MOD) % MOD;
                txtHash = ((BASE * txtHash) % MOD + (txt.charAt(i + m) - 'a')) % MOD;
            }
        }

        return indices;
    }
}
