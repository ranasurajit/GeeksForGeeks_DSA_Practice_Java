class Solution {
    /**
     * Approach : Using Binary Search Approach
     * 
     * TC: O(N x log(M))
     * SC: O(1)
     */
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (binarySearch(mat[i], m, x)) { // TC: O(log(M))
                return true;
            }
        }
        return false;
    }
    
    /**
     * Using Binary Search Approach
     * 
     * TC: O(log(M))
     * SC: O(1)
     */
    private boolean binarySearch(int[] row, int m, int x) {
        int low = 0;
        int high = m - 1;
        while (low <= high) { // TC: O(log(M))
            int mid = low + (high - low) / 2;
            if (row[mid] == x) {
                return true;
            } else if (row[mid] >= row[low]) {
                // left part is sorted
                if (x >= row[low] && x < row[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // right part is sorted
                if (x > row[mid] && x <= row[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
