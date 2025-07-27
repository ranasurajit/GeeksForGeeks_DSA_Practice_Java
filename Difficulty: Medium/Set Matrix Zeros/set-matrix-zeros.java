class Solution {
    /**
     * Approach II : Using 2D-Arrays Simulation (Without Space) Approach
     * 
     * TC: O(N x M) + O(N x M) + O(M) + O(N) ~ O(N x M)
     * SC: O(1)
     */
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean hasFirstColumnZero = false;
        // checking each row if zero then storing at mat[i][0] = -1
        for (int i = 0; i < n; i++) {     // TC: O(N)
            for (int j = 0; j < m; j++) { // TC: O(M)
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;
                    if (j != 0) {
                        mat[0][j] = 0;
                    } else {
                        hasFirstColumnZero = true;
                    }
                }
            }
        }
        // modifying for all cells (1, 1) to (n - 1, m - 1)
        for (int i = 1; i < n; i++) {     // TC: O(N)
            for (int j = 1; j < m; j++) { // TC: O(M)
                if (mat[i][j] != 0) {
                    if (mat[i][0] == 0 || mat[0][j] == 0) {
                        mat[i][j] = 0;
                    }
                }
            }
        }
        // modifying for 0th row
        if (mat[0][0] == 0) {
            for (int j = 0; j < m; j++) { // TC: O(M)
                mat[0][j] = 0;
            }
        }
        // modifying for 0th column
        if (hasFirstColumnZero) {
            for (int i = 0; i < n; i++) { // TC: O(N)
                mat[i][0] = 0;
            }
        }
    }

    /**
     * Approach I : Using 2D-Arrays Simulation Approach
     * 
     * TC: O(N x M) + O(N x M) ~ O(N x M)
     * SC: O(N + M)
     */
    public void setMatrixZeroesWithExtraSpace(int[][] mat) {
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
