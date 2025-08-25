class Solution {
    /**
     * Approach : Using Selection Sort Approach
     * 
     * TC: O(N x N)
     * SC: O(1)
     */
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        /**
         * Bubble sort refers to compare adjacent elements
         * and sort and at every step we place maximum value
         * at the end
         */
        for (int i = n - 1; i >= 1; i--) { // TC: O(N)
            for (int j = 0; j < i; j++) {  // TC: O(N) 
                if (arr[i] < arr[j]) {
                    // swap
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
