class Solution {
    /**
     * Approach : Using Euclid’s GCD Algorithm Approach
     * 
     * TC: O(log(N - 1)) * O(log(N - 2))
     * SC: O(log(N - 1))
     */
    int lcmTriplets(int n) {
        if (n <= 2) {
            return n;
        }
        int maxLCM = Integer.MIN_VALUE;
        /**
         * When n is large, most of the maximum LCM combinations 
         * involve numbers very close to n, and at most 4 or 5 
         * values below it
         */
        for (int i = n; i >= Math.max(1, n - 4); i--) { // TC: O(5)
            for (int j = i - 1; j >= Math.max(1, n - 4); j--) { // TC: O(5)
                for (int k = j - 1; k >= Math.max(1, n - 4); k--) { // TC: O(5)
                    maxLCM = Math.max(maxLCM, 
                        findLCM(i, findLCM(j, k))); // TC: O(log(Min(a, b))), SC: O(log(Min(a, b)))
                }
            }
        }
        return maxLCM;
    }

    /**
     * Using Euclid’s GCD Algorithm to find LCM Approach
     * 
     * TC: O(log(Min(a, b)))
     * SC: O(log(Min(a, b)))
     */
    private int findLCM(int a, int b) {
        return a * (b / gcd(a, b));
    }
    
    /**
     * Using Euclid’s GCD Algorithm Approach
     * 
     * TC: O(log(Min(a, b)))
     * SC: O(log(Min(a, b)))
     */
    private int gcd (int a, int b) {
        if (b > a) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
