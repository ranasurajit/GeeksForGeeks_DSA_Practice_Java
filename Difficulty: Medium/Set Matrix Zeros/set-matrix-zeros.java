class Solution {
    /**
     * Approach : Using 2D-Arrays Simulation Approach
     * 
     * TC: O(N x M) + O(N x M) ~ O(N x M)
     * SC: O(N + M)
     */
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] rowZeros = new int[n]; // SC: O(N)
        int[] colZeros = new int[m]; // SC: O(M)
        for (int i = 0; i < n; i++) {     // TC: O(N)
            for (int j = 0; j < m; j++) { // TC: O(M)
                if (mat[i][j] == 0) {
                    rowZeros[i] = -1;
                    colZeros[j] = -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {     // TC: O(N)
            for (int j = 0; j < m; j++) { // TC: O(M)
                if (rowZeros[i] == -1 || colZeros[j] == -1) {
                    mat[i][j] = 0;
                }
            }
        }
    }
}
