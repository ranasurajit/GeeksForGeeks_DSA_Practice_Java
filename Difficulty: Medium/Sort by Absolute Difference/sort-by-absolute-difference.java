class Solution {
    /**
     * Approach : Using Array Sorting Approach
     * 
     * TC: O(N) + O(N x log(N)) + O(N) ~ O(N x log(N))
     * SC: O(N)
     */
    public void rearrange(int[] arr, int x) {
        int n = arr.length;
        int[][] diff = new int[n][3]; // SC: O(N x 3) ~ O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            diff[i] = new int[] { Math.abs(arr[i] - x), i, arr[i] };
        }
        Arrays.sort(diff, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });                           // TC: O(N x log(N))
        for (int i = 0; i < n; i++) { // TC: O(N)
            arr[i] = diff[i][2];
        }
    }
}
