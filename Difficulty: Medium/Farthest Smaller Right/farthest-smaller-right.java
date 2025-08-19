class Solution {
    /**
     * Approach II : Using Optimal (Binary Search on Answers) Approach
     * 
     * TC: O(N) + O(N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     * 
     * Accepted (1114 / 1114 testcases passed)
     */
    public ArrayList<Integer> farMin(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> indices = new ArrayList<Integer>();
        int[] suffixMin = new int[n];      // SC: O(N)
        suffixMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) { // TC: O(N)
            suffixMin[i] = Math.min(suffixMin[i + 1], arr[i]);
        }
        for (int i = 0; i < n; i++) {      // TC: O(N)
            int idx = i < n - 1 ? 
                findSmallestIndex(suffixMin, i + 1, n - 1, arr[i]) : -1; // TC: O(log(N))
            indices.add(idx);
        }
        return indices;
    }
    
    /**
     * Using Binary Search Approach
     * 
     * TC: O(log(N))
     * SC: O(1)
     */
    private int findSmallestIndex(int[] suffixMin, int low, int high, int target) {
        int index = -1;
        while (low <= high) { // TC: O(log(N))
            int mid = low + (high - low) / 2;
            if (suffixMin[mid] < target) {
                index = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }

    /**
     * Approach I : Using Brute-Force (Simulation) Approach
     * 
     * TC: O(N x N)
     * SC: O(1)
     * 
     * Time Limit Exceeded (1113 / 1114 testcases passed)
     */
    public ArrayList<Integer> farMinBruteForce(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> indices = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            indices.add(-1);
            for (int j = n - 1; j > i; j--) { // TC: O(N)
                if (arr[j] < arr[i]) {
                    indices.set(i, j);
                    break;
                }
            }
        }
        return indices;
    }
}
