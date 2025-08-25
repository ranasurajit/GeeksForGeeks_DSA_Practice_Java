class Solution {
    /**
     * Approach : Using Bubble Sort Approach
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
            boolean didSwap = false;
            for (int j = 0; j < i; j++) {  // TC: O(N) 
                if (arr[j + 1] < arr[j]) {
                    // swap
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    didSwap = true;
                }
            }
            if (!didSwap) {
                break;
            }
        }
    }
}
