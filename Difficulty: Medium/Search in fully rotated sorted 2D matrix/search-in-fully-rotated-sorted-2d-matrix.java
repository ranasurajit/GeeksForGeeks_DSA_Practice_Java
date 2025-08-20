class Solution {
    /**
     * Approach II : Using Binary Search on 2D Matrix Approach
     * 
     * TC: O(log(N x M))
     * SC: O(1)
     */
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0;
        int high = n * m - 1;
        while (low <= high) { // TC: O(log(N x M))
            int mid = low + (high - low) / 2;
            // converting 1D indices to 2D indices for mid
            int rowMid = mid / m;
            int colMid = mid % m;
            int midVal = mat[rowMid][colMid];
            // converting 1D indices to 2D indices for low and high
            int lowVal = mat[low / m][low % m];
            int highVal = mat[high / m][high % m];
            if (midVal == x) {
                return true;
            } else if (midVal >= lowVal) {
                // left side is sorted
                if (x >= lowVal && x < midVal) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                // right side is sorted
                if (x > midVal && x <= highVal) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
    
    /**
     * Approach I : Using Binary Search By Rows Approach
     * 
     * TC: O(N x log(M))
     * SC: O(1)
     */
    public boolean searchMatrixBinarySearchByRows(int[][] mat, int x) {
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
