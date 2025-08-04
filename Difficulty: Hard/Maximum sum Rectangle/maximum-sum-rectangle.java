class Solution {
    /**
     * Approach : Using Kadane's Algorithm Approach
     * 
     * TC: O(M ^ 2 x (N + N)) ~ O(N x M ^ 2)
     * SC: O(N)
     */
    public int maxRectSum(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        // consolidating sum of all row cells into 1 column cell one by one
        int[] colData = new int[n]; // SC: O(N)
        int maxSum = Integer.MIN_VALUE;
        for (int start = 0; start < m; start++) {   // TC: O(M)
            Arrays.fill(colData, 0);
            for (int end = start; end < m; end++) { // TC: O(M)
                for (int i = 0; i < n; i++) {       // TC: O(N)
                    colData[i] += mat[i][end];
                }
                maxSum = Math.max(maxSum, getMaxSumByKadaneAlgorithm(colData, n)); // TC: O(N)
            }
        }
        return maxSum;
    }
    
    /**
     * Using Kadane's Algorithm Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private int getMaxSumByKadaneAlgorithm(int[] colData, int n) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            currentSum += colData[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
};
