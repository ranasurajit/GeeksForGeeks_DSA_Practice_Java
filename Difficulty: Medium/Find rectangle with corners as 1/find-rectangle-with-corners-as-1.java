class Solution {
    /**
     * Approach : Using Hashing Approach
     * 
     * TC: O(N x M ^ 2)
     * SC: O(N)
     */
    public boolean ValidCorner(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        Set<String> pairSet = new HashSet<String>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 0; j < m - 1; j++) { // TC: O(M)
                for (int k = j + 1; k < m; k++) { // TC: O(M)
                    if (mat[i][j] == 1 && mat[i][k] == 1) {
                        String key = j + "-" + k;
                        if (pairSet.contains(key)) {
                            return true;
                        }
                        pairSet.add(key);
                    }
                }
            }
        }
        return false;
    }
}
