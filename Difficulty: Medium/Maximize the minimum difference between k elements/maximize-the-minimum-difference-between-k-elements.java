class Solution {
    /**
     * Approach : Using Binary Search on Answers Approach
     * 
     * TC: O(N x log(Max(arr) - Min(arr))) + O(N x log(N)) ~ O(N x log(N))
     * SC: O(1)
     */
    public int maxMinDiff(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr); // TC: O(N x log(N))
        int low = 0;
        int high = arr[n - 1] - arr[0]; // maximum difference possible
        int result = 0;
        while (low <= high) { // TC: O(log(Max(arr) - Min(arr)))
            int mid = low + (high - low) / 2;
            if (countOfElementsPlaced(arr, n, mid) < k) { // TC: O(N)
                // lower the difference
                high = mid - 1;
            } else {
                result = Math.max(result, mid);
                low = mid + 1;
            }
        }
        return result;
    }

    /**
     * Using Simulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private int countOfElementsPlaced(int[] arr, int n, int minDiff) {
        int count = 1; // pick the first element
        int last = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] - last >= minDiff) {
                count++;
                last = arr[i];
            }
        }
        return count;
    }
}
