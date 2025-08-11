class Solution {
    public int maxSum(String s) {
        int n = s.length();

        // Initialize rolling hash 
        // for s and its reverse
        RollingHash fHash = new RollingHash(s);
        String rev = new StringBuilder(s).reverse().toString();
        RollingHash rHash = new RollingHash(rev);

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        Arrays.fill(leftMax, 1);
        Arrays.fill(rightMax, 1);

        // Compute longest odd-length palindrome 
        // ending at each index
        for (int i = 0; i < n; i++) {
            int lo = 0, hi = Math.min(i, n - 1 - i);
            int best = 1;

            // Binary search for maximum radius
            while (lo <= hi) {
                int m = (lo + hi) / 2;
                int start = i - m;
                int end = i + m;
                if (isPalindrome(start, end, fHash, rHash, n)) {
                    best = 2 * m + 1;
                    lo = m + 1;
                } else {
                    hi = m - 1;
                }
            }

            int endIdx = i + best / 2;
            if (endIdx < n)
                leftMax[endIdx] = Math.max(leftMax[endIdx], best);
        }

        // Relax leftMax array to 
        // cover entire left side
        for (int i = n - 2; i >= 0; i--)
            leftMax[i] = Math.max(leftMax[i], leftMax[i + 1] - 2);
        for (int i = 1; i < n; i++)
            leftMax[i] = Math.max(leftMax[i], leftMax[i - 1]);

        // Compute longest odd-length palindrome 
        // starting at each index
        for (int i = n - 1; i >= 0; i--) {
            int lo = 0, hi = Math.min(i, n - 1 - i);
            int best = 1;

            while (lo <= hi) {
                int m = (lo + hi) / 2;
                int start = i - m;
                int end = i + m;
                if (isPalindrome(start, end, fHash, rHash, n)) {
                    best = 2 * m + 1;
                    lo = m + 1;
                } else {
                    hi = m - 1;
                }
            }

            int startIdx = i - best / 2;
            if (startIdx >= 0){
                rightMax[startIdx] = 
                        Math.max(rightMax[startIdx], best);
            }
        }

        // Relax rightMax array to 
        // cover entire right side
        for (int i = 1; i < n; i++){
            rightMax[i] = 
                Math.max(rightMax[i], rightMax[i - 1] - 2);
        }
        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i], rightMax[i + 1]);

      
        // Combine the two arrays to 
        // compute the maximum sum
        int ans = 0;
        for (int i = 0; i + 1 < n; i++) {
            ans = Math.max(ans, leftMax[i] + rightMax[i + 1]);
        }

        return ans;
    }
    
    private static boolean isPalindrome(int l, int r, 
                        RollingHash fHash, RollingHash rHash, int n) {
                            
        int h1 = fHash.getHash(l, r);
        int h2 = rHash.getHash(n - 1 - r, n - 1 - l);
        return h1 == h2;
    }
    
    class RollingHash {
        static final int BASE = 911;
        static final int MOD = 1000000007;
    
        int[] hash;
        int[] power;
    
        // constructor: Precomputes prefix 
        // hashes and powers of base
        public RollingHash(String s) {
            int n = s.length();
            hash = new int[n + 1];
            power = new int[n + 1];
            hash[0] = 0;
            power[0] = 1;
    
            for (int i = 0; i < n; i++) {
                hash[i + 1] = (int)((1L * hash[i] * BASE + s.charAt(i)) % MOD);
                power[i + 1] = (int)((1L * power[i] * BASE) % MOD);
            }
        }
    
        // Returns hash of substring s[l...r]
        public int getHash(int l, int r) {
            int val = (int)((hash[r + 1]
                           - 1L * hash[l] * power[r - l + 1] % MOD
                           + MOD) % MOD);
            return val;
        }
    }
    
    /**
     * Approach : Using Two Pointers + Array Pre-processing (Brute-Force) Approach
     * 
     * TC: O(N x N) + O(N) + O(N x N) + O(N) + O(N) ~ O(N x N)
     * SC: O(N) + O(N)
     * 
     * Time Limit Exceeded (1110 / 1120 testcases passed)
     */
    public int maxSumBruteForce(String s) {
        int n = s.length();
        int[] leftMax = new int[n]; // SC: O(N)
        int[] rightMax = new int[n]; // SC: O(N)
        // we will go from left to right to fill all palindromes of odd length
        for (int i = 0; i < n; i++) { // TC: O(N)
            int start = i;
            int end = i;
            while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) { // TC: O(N)
                int len = end - start + 1;
                leftMax[end] = Math.max(leftMax[end], len);
                start--;
                end++;
            }
        }
        for (int i = 1; i < n; i++) { // TC: O(N)
            leftMax[i] = Math.max(leftMax[i], leftMax[i - 1]);
        }
        // we will go from right to left to fill all palindromes of odd length
        for (int i = 0; i < n; i++) { // TC: O(N)
            int start = i;
            int end = i;
            while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) { // TC: O(N)
                int len = end - start + 1;
                rightMax[start] = Math.max(rightMax[start], len);
                start--;
                end++;
            }
        }
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            rightMax[i] = Math.max(rightMax[i], rightMax[i + 1]);
        }
        int result = 0;
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            result = Math.max(result, leftMax[i] + rightMax[i + 1]);
        }
        return result;
    }
}
