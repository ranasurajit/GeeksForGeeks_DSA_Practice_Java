class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     * 
     * Time Limit Exceeded (1110 / 1111 testcases passed)
     */
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        // mat[i] = arr[i] x arr[i - 1] so i can start from 1 to (n - 1)
        int[][] memo = new int[n][n];
        for (int[] mem : memo) {
            Arrays.fill(mem, -1);
        }
        return solveMemoization(1, n - 1, arr, memo);
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    private static int solveMemoization(int i, int j, int[] arr, int[][] memo) {
        // Base Case
        if (i >= j) {
            // i cannot cross j, i cannot be equal to j as we need arr[i] and arr[i - 1] for i
            return 0;
        }
        // Memoization
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        // Recursion Calls
        int minMult = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) { // TC: O(N)
            // currentMult = Operation(i, k) + Operation(k + 1, j) + Arr[i - 1] x Arr[k] x Arr[j]
            int currentMult = solveMemoization(i, k, arr, memo) + 
                solveMemoization(k + 1, j, arr, memo) + arr[i - 1] * arr[k] * arr[j];
            minMult = Math.min(minMult, currentMult);
        }
        return memo[i][j] = minMult;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     * 
     * Time Limit Exceeded (1110 / 1111 testcases passed)
     */
    static int matrixMultiplicationRecursion(int arr[]) {
        int n = arr.length;
        // mat[i] = arr[i] x arr[i - 1] so i can start from 1 to (n - 1)
        return solveRecursion(1, n - 1, arr);
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    private static int solveRecursion(int i, int j, int[] arr) {
        // Base Case
        if (i >= j) {
            // i cannot cross j, i cannot be equal to j as we need arr[i] and arr[i - 1] for i
            return 0;
        }
        // Recursion Calls
        int minMult = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) { // TC: O(N)
            // currentMult = Operation(i, k) + Operation(k + 1, j) + Arr[i - 1] x Arr[k] x Arr[j]
            int currentMult = solveRecursion(i, k, arr) + 
                solveRecursion(k + 1, j, arr) + arr[i - 1] * arr[k] * arr[j];
            minMult = Math.min(minMult, currentMult);
        }
        return minMult;
    }
}
