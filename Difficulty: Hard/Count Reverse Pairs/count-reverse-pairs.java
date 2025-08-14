class Solution {
    /**
     * Approach : Using Merge Sort Approach
     * 
     * TC: O(2 x N x log(N)) ~ O(N x log(N))
     * SC: O(N)
     */
    public int countRevPairs(int[] arr) {
        int n = arr.length;
        return mergeSort(arr, 0, n - 1);
    }
    
    /**
     * Using Merge Sort Approach
     * 
     * TC: O(2 x N x log(N))
     * SC: O(N)
     */
    private int mergeSort(int[] arr, int low, int high) {
        int count = 0;
        if (low >= high) {
            return count;
        }
        int mid = low + (high - low) / 2;
        count += mergeSort(arr, low, mid); // TC: O(N x log(N))
        count += mergeSort(arr, mid + 1, high); // TC: O(N x log(N))
        count += countPairs(arr, low, mid, high); // TC: O(N / 2)
        merge(arr, low, mid, high); // TC: O(N), SC: O(N)
        return count;
    }
    
    /**
     * Using Merge Sort Approach
     * 
     * TC: O(N / 2)
     * SC: O(1)
     */
    private int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int count = 0;
        for (int i = low; i <= mid; i++) { // TC: O(N / 2)
            while (right <= high && arr[i] > 2 * arr[right]) {
                right++;
            }
            count += (right - (mid + 1));
        }
        return count;
    }
    
    /**
     * Using Merging of Two Sorted Arrays Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    private void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<Integer>();
        int left = low;
        int right = mid + 1;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    /**
     * Approach I : Brute-Force Approach
     * 
     * TC: O(N x N)
     * SC: O(1)
     * 
     * Time Limit Exceeded (1110 / 1120 testcases passed)
     */
    public int countRevPairsBruteForce(int[] arr) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {     // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (arr[i] > 2 * arr[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
