class Solution {
    /**
     * Approach : Using 2-D Array Simulation (3 - Pass Approach)
     * 
     * TC: O(N x N) + O(N x N) + O(N x N) ~ O(N x N)
     * SC: O(1)
     */
    public static int balanceSums(int[][] mat) {
        int n = mat.length;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {      // TC: O(N)
            int currentSum = 0;
            for (int j = 0; j < n; j++) {  // TC: O(N)
                currentSum += mat[i][j];
            }
            maxSum = Math.max(maxSum, currentSum);
        }
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
