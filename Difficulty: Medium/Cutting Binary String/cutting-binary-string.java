class Solution {
    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    public int cuts(String s) {
        int n = s.length();
        int minCuts = solveRecursion(0, n, s);
        return minCuts == Integer.MAX_VALUE ? -1 : minCuts;
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int idx, int n, String s) {
        // Base Case
        if (idx == n) {
            return 0;
        }
        if (s.charAt(idx) == '0') {
            // No substring should have leading zeros
            return Integer.MAX_VALUE;
        }
        int minCuts = Integer.MAX_VALUE;
        // Recursion Calls
        for (int i = idx; i < n; i++) { // TC: O(N)
            String sub = s.substring(idx, i + 1);
            if (isPowerOfFive(sub)) { // TC: O(L)
                int cuts = solveRecursion(i + 1, n, s);
                if (cuts != Integer.MAX_VALUE) {
                    // as we got 1 split/cut so we added 1
                    minCuts = Math.min(minCuts, cuts + 1);
                }
            }
        }
        return minCuts;
    }

    /**
     * Using Simulation + Binary Conversion Approach
     * 
     * TC: O(L) where L = length of String sub
     * SC: O(1)
     */
    private boolean isPowerOfFive(String sub) {
        if (sub.charAt(0) == '0') {
            // No substring should have leading zeros
            return false;
        }
        long num = Long.parseLong(sub, 2); // converting binary string to decimal
        while (num > 0 && num % 5 == 0) {
            num = num / 5;
        }
        return num == 1L;
    }
}
