class Solution {
    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    public int countConsec(int n) {
        /**
         * total combinations we can make using 0's and 1's of length n String is 2 ^ N
         * so, we need to compute number of Strings having no consective 1's
         */
        int result = solveRecursion(n, 0); // TC: O(2 ^ N), SC: O(N)
        return (int) Math.pow(2, n) - result;
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int n, int lastBit) {
        // Base Case
        if (n == 0) {
            return 1;
        }
        // Recursion Calls
        if (lastBit == 0) {
            // we can place either 0 or 1 - does not matter as it will not place two 1's i.e. 11
            return solveRecursion(n - 1, 0) + solveRecursion(n - 1, 1);
        } else {
            // we can place only zero as if we choose 1 then we may end up getting 11
            return solveRecursion(n - 1, 0);
        }
    }
}
