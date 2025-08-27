class Solution {
    /**
     * Approach : Using Recursion + Two Pointers Approach
     * 
     * TC: O(N x log(N)), Worst Case TC: O(N ^ 2)
     * SC: O(log(N)), Worst Case SC: O(N)
     * 
     * worst case happens if Array 'arr' is sorted (ascending/descending)
     * or all elements equal
     */
    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // guarantees for atleast two elements in array 'arr'
            int pivotIdx = partition(arr, low, high); // TC: O(N)
            quickSort(arr, low, pivotIdx - 1);  // TC: O(log(N))
            quickSort(arr, pivotIdx + 1, high); // TC: O(log(N))
        }
    }

    /**
     * Using Two Pointers Approach
     * 
     * TC: O(High - Low) ~ O(N)
     * SC: O(1)
     */
    private int partition(int[] arr, int low, int high) {
        int n = arr.length;
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j) { // TC: O(High - Low)
            while (i < n && arr[i] <= pivot) {
                i++;
            }
            while (j > 0 && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                // swap elements arr[i], arr[j] so that left portion < right portion
                swap(arr, i, j);
            }
        }
        // placing the pivot variable at its correct position
        swap(arr, low, j);
        return j;
    }
    
    /**
     * Using Simulation Approach
     * 
     * TC: O(1)
     * SC: O(1)
     */
    private void swap(int[] arr, int p, int q) {
        int temp = arr[q];
        arr[q] = arr[p];
        arr[p] = temp;
    }
}
