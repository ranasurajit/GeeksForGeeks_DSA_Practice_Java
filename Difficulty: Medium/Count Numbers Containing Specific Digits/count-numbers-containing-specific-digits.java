class Solution {
    /**
     * Approach IV : Using Space Optimization (Optimized DP) Approach
     * 
     * TC: O(N) + O(40 x N) ~ O(N)
     * SC: O(N)
     * 
     * Accepted (230 / 230 testcases passed)
     */
    public int countValid(int n, int[] arr) {
        Set<Integer> hs = new HashSet<Integer>(); // SC: O(N)
        for (int elem : arr) { // TC: O(N)
            hs.add(elem);
        }
        // Intitalization
        int[][] next = new int[2][2]; // SC: O(4) ~ O(1)
        for (int isStart = 0; isStart < 2; isStart++) {        // TC: O(2)
            for (int hasDigit = 0; hasDigit < 2; hasDigit++) { // TC: O(2)
                next[isStart][hasDigit] = hasDigit == 1 ? 1 : 0;
            }
        }
        // Iterative Calls
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            int[][] current = new int[2][2]; // SC: O(4) ~ O(1)
            for (int isStart = 0; isStart < 2; isStart++) { // TC: O(2)
                for (int hasDigit = 0; hasDigit < 2; hasDigit++) { // TC: O(2)
                    for (int digit = 0; digit <= 9; digit++) { // TC: O(10)
                        if (isStart == 1 && digit == 0) {
                            continue;
                        }
                        int containsDigit = (hasDigit == 1) || hs.contains(digit) ? 1 : 0;
                        current[isStart][hasDigit] += next[0][containsDigit];
                    }
                }
            }
            for (int p = 0; p < current.length; p++) {
                next[p] = current[p].clone();
            }
        }
        return next[1][0];
    }

    /**
     * Approach III : Using Tabulation (Bottom-Up DP) Approach
     * 
     * TC: O(N) + O(40 x N) ~ O(N)
     * SC: O(N) + O(N)
     * 
     * Accepted (230 / 230 testcases passed)
     */
    public int countValidTabulation(int n, int[] arr) {
        Set<Integer> hs = new HashSet<Integer>(); // SC: O(N)
        for (int elem : arr) { // TC: O(N)
            hs.add(elem);
        }
        // Intitalization
        int[][][] dp = new int[n + 1][2][2]; // SC: O(4 x N) ~ O(N)
        for (int isStart = 0; isStart < 2; isStart++) {        // TC: O(2)
            for (int hasDigit = 0; hasDigit < 2; hasDigit++) { // TC: O(2)
                dp[n][isStart][hasDigit] = hasDigit == 1 ? 1 : 0;
            }
        }
        // Iterative Calls
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            for (int isStart = 0; isStart < 2; isStart++) { // TC: O(2)
                for (int hasDigit = 0; hasDigit < 2; hasDigit++) { // TC: O(2)
                    for (int digit = 0; digit <= 9; digit++) { // TC: O(10)
                        if (isStart == 1 && digit == 0) {
                            continue;
                        }
                        int containsDigit = (hasDigit == 1) || hs.contains(digit) ? 1 : 0;
                        dp[i][isStart][hasDigit] += dp[i + 1][0][containsDigit];
                    }
                }
            }
        }
        return dp[0][1][0];
    }

    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(N) + O(N) + O(N)
     * 
     * Accepted (230 / 230 testcases passed)
     */
    public int countValidMemoization(int n, int[] arr) {
        Set<Integer> hs = new HashSet<Integer>(); // SC: O(N)
        for (int elem : arr) { // TC: O(N)
            hs.add(elem);
        }
        int[][][] memo = new int[n][2][2]; // SC: O(4 x N) ~ O(N)
        for (int[][] mem : memo) {
            for (int[] m : mem) {
                Arrays.fill(m, -1);
            }
        }
        return solveMemoization(0, n, 1, 0, hs, memo); // TC: O(N), SC: O(N)
    }
    
    /**
     * Using Memoization Approach
     *
     * TC: O(9 x N x 2 x 2) ~ O(N)
     * SC: O(N)
     */
    private int solveMemoization(int idx, int n, int isStart,
        int hasDigit, Set<Integer> hs, int[][][] memo) {
        // Base Case
        if (idx == n) {
            return hasDigit == 1 ? 1 : 0;
        }
        // Memoization Check
        if (memo[idx][isStart][hasDigit] != -1) {
            return memo[idx][isStart][hasDigit];
        }
        int total = 0;
        for (int i = 0; i <= 9; i++) {
            if (isStart == 1 && i == 0) {
                continue;
            }
            int containsDigit = (hasDigit == 1) || hs.contains(i) ? 1 : 0;
            total += solveMemoization(idx + 1, n, 0, containsDigit, hs, memo);
        }
        return memo[idx][isStart][hasDigit] = total;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(N) + O(10 ^ N) ~ O(10 ^ N)
     * SC: O(N) + O(N)
     * 
     * Time Limit Exceeded (10 / 230 testcases passed)
     */
    public int countValidRecursion(int n, int[] arr) {
        Set<Integer> hs = new HashSet<Integer>(); // SC: O(N)
        for (int elem : arr) { // TC: O(N)
            hs.add(elem);
        }
        return solveRecursion(0, n, true, false, hs); // TC: O(10 ^ N), SC: O(N)
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(9 x 10 ^ N) ~ O(10 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int idx, int n, boolean isStart,
        boolean hasDigit, Set<Integer> hs) {
        // Base Case
        if (idx == n) {
            return hasDigit ? 1 : 0;
        }
        int total = 0;
        for (int i = 0; i <= 9; i++) {
            if (isStart && i == 0) {
                continue;
            }
            boolean containsDigit = hasDigit || hs.contains(i);
            total += solveRecursion(idx + 1, n, false, containsDigit, hs);
        }
        return total;
    }
}
