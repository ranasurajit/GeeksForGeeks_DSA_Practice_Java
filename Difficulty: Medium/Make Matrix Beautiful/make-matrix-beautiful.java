class Solution {
    /**
     * Approach II : Using 2-D Array Simulation (Runtime Optimized Approach)
     * 
     * TC: O(N x N) + O(N) + O(N) ~ O(N x N)
     * SC: O(N) + O(N) ~ O(N)
     */
    public static int balanceSums(int[][] mat) {
        int n = mat.length;
        int maxSum = 0;
        int[] rowSum = new int[n];         // SC: O(N)
        int[] colSum = new int[n];         // SC: O(N)
        // calculating maxSum across rows and columns
        for (int i = 0; i < n; i++) {      // TC: O(N)
            for (int j = 0; j < n; j++) {  // TC: O(N)
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }
        for (int i = 0; i < n; i++) {      // TC: O(N)
            maxSum = Math.max(maxSum, rowSum[i]);
            maxSum = Math.max(maxSum, colSum[i]);
        }
        // total operations = filling the diff in rows or columns
        int operations = 0;
        for (int i = 0; i < n; i++) {     // TC: O(N)
            operations += (maxSum - rowSum[i]);
        }
        return operations;
    }

    /**
     * Approach I : Using 2-D Array Simulation (No Extra Space Approach)
     * 
     * TC: O(N x N) + O(N x N) + O(N x N) ~ O(N x N)
     * SC: O(1)
     */
    public static int balanceSumsNoExtraSpace(int[][] mat) {
        int n = mat.length;
        int maxSum = 0;
        // calculating maxSum across rows
        for (int i = 0; i < n; i++) {      // TC: O(N)
            int currentSum = 0;
            for (int j = 0; j < n; j++) {  // TC: O(N)
                currentSum += mat[i][j];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        // calculating maxSum across columns
        for (int j = 0; j < n; j++) {      // TC: O(N)
            int currentSum = 0;
            for (int i = 0; i < n; i ++) { // TC: O(N)
                currentSum += mat[i][j];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        // total operations = filling the diff in rows or columns
        int operations = 0;
        for (int i = 0; i < n; i++) {     // TC: O(N)
            int currentSum = 0;
            for (int j = 0; j < n; j++) { // TC: O(N)
                currentSum += mat[i][j];
            }
            operations += (maxSum - currentSum);
        }
        return operations;
    }
}
