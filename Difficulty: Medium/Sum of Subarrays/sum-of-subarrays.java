class Solution {
    /**
     * Approach II : Using Math + Element Contribution Approach
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * Accepted (1120 / 1120 testcases passed)
     */
    public int subarraySum(int[] arr) {
        int n = arr.length;
        long sum = 0;
        /**
         * For n = 7,
         * 
         * Freq of contribution of each element index = 
         * 
         * [1, 2, 3, 4, 5, 6, 7] => [7, 12, 15, 16, 15, 12, 7]
         * so 1 appears 7 times, 2 appears 12 times and so on..
         * 
         * sum = 1 x 7 + 2 x 12 + ....
         * 
         * Logic becomes : arr[i] * freq (arr[i])
         * 
         * freq = (i + 1) x (n - i)
         */
        for (int i = 0; i < n; i++) {          // TC: O(N)
            long freq = ((long) (i + 1) * (n - i));
            sum += (freq * arr[i]);
        }
        return (int) sum;
    }

    /**
     * Approach I : Using Brute-Force Approach
     * 
     * TC: O(N ^ 3)
     * SC: O(1)
     * 
     * Time Limit Exceeded (1110 / 1120 testcases passed)
     */
    public int subarraySumBruteForce(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {          // TC: O(N)
            for (int j = i; j < n; j++) {      // TC: O(N)
                for (int k = i; k <= j; k++) { // TC: O(N)
                    sum += arr[k];
                }
            }
        }
        return sum;
    }
}
