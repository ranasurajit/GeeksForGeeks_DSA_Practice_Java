class Solution {
    /**
     * Approach I : Using Brute-Force Approach
     * 
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public int[] leftSmaller(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        nse[0] = -1;
        for (int i = 1; i < n; i++) { // TC: O(N)
            boolean isFound = false;
            for (int j = i - 1; j >= 0; j--) { // TC: O(N)
                if (arr[j] < arr[i]) {
                    isFound = true;
                    nse[i] = arr[j];
                    break;
                }
            }
            if (!isFound) {
                nse[i] = -1;
            }
        }
        return nse;
    }
}
