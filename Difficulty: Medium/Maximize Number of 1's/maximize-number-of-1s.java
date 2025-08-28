class Solution {
    /**
     * Approach : Using Sliding Window (Variable Size) Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int maxOnes(int arr[], int k) {
        int n = arr.length;
        int countZeroes = 0;
        int i = 0; // start pointer of sliding window
        int j = 0; // end pointer of sliding window
        int maxLength = 0;
        while (j < n) { // TC: O(N)
            countZeroes += arr[j] == 0 ? 1 : 0;
            while (countZeroes > k) {
                // remove computation from index 'i'
                countZeroes -= arr[i] == 0 ? 1 : 0;
                // shrink the window
                i++;
            }
            // ensuring that zeroes count do not exceed k 
            maxLength = Math.max(maxLength, j - i + 1);
            // slide to next window
            j++;
        }
        return maxLength;
    }
}
