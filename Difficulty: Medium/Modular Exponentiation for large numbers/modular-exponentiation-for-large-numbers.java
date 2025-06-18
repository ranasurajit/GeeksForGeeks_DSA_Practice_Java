// User function Template for Java

class Solution {
    /**
     * Approach : Using Recursion + Modulo Arithmetic Approach
     * 
     * TC: O(log(N))
     * SC: O(log(N))
     */
    public long PowMod(long x, long n, long m) {
        return fastPower(x, n, m);
    }
    
    /**
     * Using Recursion + Modulo Arithmetic Approach
     * 
     * TC: O(log(N))
     * SC: O(log(N))
     */
    private long fastPower(long x, long n, long m) {
        // Base Case
        if (n == 0) {
            return 1L;
        }
        // Recursion Calls
        long half = fastPower(x, n / 2, m) % m;
        long answer = (half * half) % m;
        if ((n % 2) == 1) {
            // n is odd
            return (x * answer) % m;
        }
        return answer % m;
    }
}
