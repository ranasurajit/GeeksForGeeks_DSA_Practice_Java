class Solution {
    /**
     * Approach : Using Math + Simulation Approach
     * 
     * TC: O(Sqrt(N))
     * SC: O(1)
     */
    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        int countDivs = 0;
        for (int i = 2; i * i <= n; i++) { // TC: O(Sqrt(N))
            if (n % i == 0) {
                countDivs++;
            }
        }
        return countDivs == 0;
    }
}
