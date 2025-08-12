class Solution {
    /**
     * Approach : Using Greedy Algorithm + Sorting Approach
     * 
     * TC: O(N x log(N)) + O(N) + O(N) ~ O(N x log(N))
     * SC: O(1)
     */
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        int n = prices.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        /**
         * To get the maximum candies free we need to sort the array 'prices'
         */
        Arrays.sort(prices); // TC: O(N x log(N))
        int minAmount = 0;
        int maxAmount = 0;
        // minimum amount calculation
        int p = 0;
        int q = n - 1;
        while (p <= q) { // TC: O(N)
            minAmount += prices[p];
            p++;
            q = q - k;
        }
        // maximum amount calculation
        p = n - 1;
        q = 0;
        while (p >= q) { // TC: O(N)
            maxAmount += prices[p];
            p--;
            q = q + k;
        }
        result.add(minAmount);
        result.add(maxAmount);
        return result;
    }
}
