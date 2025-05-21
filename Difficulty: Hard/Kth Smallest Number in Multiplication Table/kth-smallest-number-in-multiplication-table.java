class Solution {
    public int kthSmallest(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int countNums = getCountNumbersLessThanEquals(m, n, mid);
            // we need to have (k - 1) elements less than the kth element
            if (countNums < k) {
                low = mid + 1;
            } else if (countNums > k - 1) {
                high = mid - 1;
            }
        }
        return low;
    }
    
    private int getCountNumbersLessThanEquals(int m, int n, int mid) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, mid / i);
        }
        return count;
    }
}
