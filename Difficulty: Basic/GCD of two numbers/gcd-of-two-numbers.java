class Solution {
    /**
     * Approach II : Using Euler's Euclidean GCD Algorithm Approach
     * 
     * TC: O(log(Min(a, b)))
     * SC: O(log(Min(a, b)))
     * 
     * Accepted (1115 /1115 testcases passed)
     */
    public static int gcd(int a, int b) {
        if (b > a) {
            return gcd(b, a);
        }
        // ensure b < a
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * Approach I : Using Math Approach
     * 
     * TC: O(Min(a, b))
     * SC: O(1)
     * 
     * Time Limit Exceeded (1010 /1115 testcases passed)
     */
    public static int gcdBruteForce(int a, int b) {
        int n = Math.min(a, b);
        for (int i = n; i >= 1; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
