class Solution {
    /**
     * Approach : Using Sliding Window (Fixed Size) Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public int maxSum(int arr[]) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        int maxScore = 0;
        while (j < n) { // TC: O(N)
            if (j - i + 1 < 2) {
                j++;
            } else if (j - i + 1 == 2) {
                int currentScore = arr[j] + arr[i];
                maxScore = Math.max(maxScore, currentScore);
                // move to next window
                i++;
                j++;
            }
        }
        return maxScore;
    }
}
