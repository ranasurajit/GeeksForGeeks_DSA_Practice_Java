// User function Template for Java

class Solution {
    /**
     * Approach : Using Binary Search on Answers Approach
     * 
     * TC: O(N + N x log(K)) ~ O(N x log(K))
     * SC: O(1)
     * 
     * where K = Sum(arr) - Max(arr)
     * 
     * @param arr
     * @param k
     * @return
     */
    public int minTime(int[] arr, int k) {
        int n = arr.length;
        long low = 0L;
        long high = 0L;
        for (int i = 0; i < n; i++) { // TC: O(N)
            low = Math.max(low, (long) arr[i]);
            high += (long) arr[i];
        }
        // Applying Binary Search
        while (low <= high) { // TC: O(log(K))
            long mid = low + (high - low) / 2;
            long countPainters = getCountOfPainters(arr, n, mid); // TC: O(N)
            if (countPainters <= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }
    
    /**
     * Using Simulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * @param arr
     * @param n
     * @param mid
     * @return
     */
    private long getCountOfPainters(int[] arr, int n, long mid) {
        long count = 1L;
        long sum = 0L;
        for (int i = 0; i < n; i++) {
            if (sum + (long) arr[i] <= mid) {
                sum += (long) arr[i];
            } else {
                count++;
                sum = (long) arr[i];
            }
        }
        return count;
    }
}
