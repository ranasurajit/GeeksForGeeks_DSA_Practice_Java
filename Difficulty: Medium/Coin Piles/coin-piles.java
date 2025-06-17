class Solution {
    /**
     * Approach II : Using Binary Search Approach
     * 
     * TC: O(N + 2 x N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     */
    public int minimumCoins(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr); // TC: O(N x log(N))
        int[] prefixSum = new int[n]; // SC: O(N)
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        int initRemove = 0;
        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            initRemove = i == 0 ? 0 : prefixSum[i - 1];
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int idx = upperBound(arr, arr[i] + k, i, n - 1); // TC: O(log(N))
            int coinsToRemove = initRemove;
            if (idx > 0 && idx < n) {
                int totalCoinsSum = prefixSum[n - 1] - prefixSum[idx - 1];
                int allowedCoinsSum = (n - idx) * (arr[i] + k);
                coinsToRemove += (totalCoinsSum - allowedCoinsSum);
            }
            minCoins = Math.min(minCoins, coinsToRemove);
        }
        return minCoins;
    }

    /**
     * Using Binary Search Approach to find Upper Bound
     * 
     * TC: O(log(N))
     * SC: O(1)
     */
    private int upperBound(int[] arr, int x, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    /**
     * Approach I : Using Linear Search Approach
     * 
     * TC: O(N + N x log(N) + N x N) ~ O(N x N)
     * SC: O(N)
     */
    public int minimumCoinsApproachI(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr); // TC: O(N x log(N))
        int[] prefixSum = new int[n]; // SC: O(N)
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        int initRemove = 0;
        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            initRemove = i == 0 ? 0 : prefixSum[i - 1];
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int allowedCoins = arr[i] + k;
            int idx = -1;
            for (int j = i; j < n; j++) { // TC: O(N)
                if (arr[j] > allowedCoins) {
                    idx = j;
                    break;
                }
            }
            int extraCoins = initRemove;
            if (idx > 0 && idx < n) {
                int totalCoinsSum = prefixSum[n - 1] - prefixSum[idx - 1];
                int totalCoinsSumAllowed = allowedCoins * (n - idx);
                extraCoins += totalCoinsSum - totalCoinsSumAllowed;
            }
            minCoins = Math.min(minCoins, extraCoins);
        }
        return minCoins;
    }
}
