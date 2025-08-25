class Solution {
    // Please change the array in-place
    /**
     * Approach : Using Insertion Sort Approach
     * 
     * TC: O(N x N)
     * SC: O(1)
     */
    public void insertionSort(int arr[]) {
        int n = arr.length;
        /**
         * We need to pick each element and insert it into 
         * its sorted position comparing the element to its
         * left
         */
        for (int i = 1; i < n; i++) { // TC: O(N)
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) { // TC: O(N - 1)
                // swap arr[j] with arr[j - 1]
                int temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
    }
}
