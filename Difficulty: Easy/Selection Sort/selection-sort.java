class Solution {
    /**
     * Approach : Using Selection Sort Approach
     * 
     * TC: O(N x N)
     * SC: O(1)
     */
    void selectionSort(int[] arr) {
        int n = arr.length;
        /**
         * Selection sort means in every loop, select the minimum
         * and replace it in the place where the loop started
         */
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            int minIdx = i;
            for (int j = i; j < n; j++) { // TC: O(N)
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // swap arr[minIdx] with arr[i]
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
