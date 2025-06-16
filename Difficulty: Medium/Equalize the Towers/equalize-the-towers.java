class Solution {
    /**
     * Approach II : Using Ternary Search on Answers Approach
     * 
     * TC: O(N x log(Max(heights) - Min(heights)) Base 3)
     * SC: O(1)
     * 
     * Accepted : Test Cases Passed (1112 /1112)
     */
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;
        int low = Integer.MAX_VALUE;  // smallest height
        int high = Integer.MIN_VALUE; // largest height
        for (int i = 0; i < n; i++) { // TC: O(N)
            low = Math.min(low, heights[i]);
            high = Math.max(high, heights[i]);
        }
        // now we will be making all heights from 'low' to 'high' and compare the cost
        // Using Ternary Search to optimize the computation
        while (high - low > 2) { // TC: O(Max(heights) - Min(heights))
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            long cost1 = getCurrentCost(heights, cost, n, mid1);
            long cost2 = getCurrentCost(heights, cost, n, mid2);
            if (cost1 < cost2) {
                high = mid2;
            } else {
                low = mid1;
            }
        }
        // now we will be making all heights from 'low' to 'high' and compare the cost
        long minCost = Long.MAX_VALUE;
        for (int hgt = low; hgt <= high; hgt++) { // TC: O(2)
            minCost = Math.min(minCost, getCurrentCost(heights, cost, n, hgt)); // TC: O(N)
        }
        return (int) minCost;
    }

    /**
     * Approach I : Using Linear Search on Answers Approach
     * 
     * TC: O(N + O(N x (Max(heights) - Min(heights)))) ~ O(N x (Max(heights) - Min(heights)))
     * SC: O(1)
     * 
     * Time limit exceeded : Test Cases Passed (1010 /1112)
     */
    public int minCostUsingLinearSearch(int[] heights, int[] cost) {
        int n = heights.length;
        int low = Integer.MAX_VALUE;  // smallest height
        int high = Integer.MIN_VALUE; // largest height
        for (int i = 0; i < n; i++) { // TC: O(N)
            low = Math.min(low, heights[i]);
            high = Math.max(high, heights[i]);
        }
        // now we will be making all heights from 'low' to 'high' and compare the cost
        long minCost = Long.MAX_VALUE;
        for (int hgt = low; hgt <= high; hgt++) { // TC: O(Max(heights) - Min(heights))
            minCost = Math.min(minCost, getCurrentCost(heights, cost, n, hgt)); // TC: O(N)
        }
        return (int) minCost;
    }
    
    /**
     * Using Simulation Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private long getCurrentCost(int[] heights, int[] cost, int n, int hgt) {
        long currentCost = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            currentCost += Math.abs(heights[i] - hgt) * cost[i];
        }
        return currentCost;
    }
}
