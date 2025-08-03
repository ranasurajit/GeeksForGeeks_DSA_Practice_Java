class Solution {
    /**
     * Approach : Using Difference Array Approach
     * 
     * TC: O(Q) + O(N x M) + O(N x M) + O(N x M) ~ O(Q + (N x M))
     * SC: O(N x M)
     * 
     * where Q = number of operations
     */
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        int n = mat.length;
        int m = mat[0].length;
        // we will take difference array of size (n + 1) x (m + 1) to avoid spill-overs
        int[][] diffMat = new int[n + 1][m + 1]; // SC: O(N x M)
        for (int[] update : opr) { // TC: O(Q)
            int value = update[0];
            int r1 = update[1];
            int c1 = update[2];
            int r2 = update[3];
            int c2 = update[4];
            diffMat[r1][c1] += value;
            if (c2 + 1 < m + 1) {
                diffMat[r1][c2 + 1] -= value;
            }
            if (r2 + 1 < n + 1) {
                diffMat[r2 + 1][c1] -= value;
            }
            if (r2 + 1 < n + 1 && c2 + 1 < m + 1) {
                diffMat[r2 + 1][c2 + 1] += value;
            }
        }
        // accumulate result of cumulative sum across rows
        for (int i = 1; i < n; i++) { // TC: O(N)
            for (int j = 0; j < m; j++) { // TC: O(M)
                diffMat[i][j] += diffMat[i - 1][j];
            }
        }
        // accumulate result of cumulative sum across columns
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 1; j < m; j++) { // TC: O(M)
                diffMat[i][j] += diffMat[i][j - 1];
            }
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            result.add(new ArrayList<Integer>());
            for (int j = 0; j < m; j++) { // TC: O(M)
                result.get(i).add(mat[i][j] + diffMat[i][j]);
            }
        }
        return result;
    }
}
