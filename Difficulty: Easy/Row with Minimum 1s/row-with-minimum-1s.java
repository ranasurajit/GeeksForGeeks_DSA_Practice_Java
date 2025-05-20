// User function Template for Java

class Solution {
    /**
     * Approach : Using Simulation Approach
     *
     * TC: O(N x M)
     * SC: O(1)
     */
    int minRow(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int min1s = m;
        int rowIndex = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int count1s = 0;
            for (int j = 0; j < m; j++) { // TC: O(M)
                if (mat[i][j] == 1) {
                    count1s++;
                }
            }
            if (count1s < min1s) {
                min1s = count1s;
                rowIndex = i;
            }
        }
        return rowIndex + 1;
    }
}
