class Solution {
    /**
     * Approach II : Using SweepLine Algorithm Approach
     * 
     * TC: O(N) + O(N) + O(T) ~ O(N + T)
     * SC: O(T)
     * 
     * where T = Max(intervals)
     * 
     * Accepted (1115 / 1115 testcases passed)
     */
    public int powerfulInteger(int[][] intervals, int k) {
        int n = intervals.length;
        int maxInterval = -1;
        for (int[] interval : intervals) { // TC: O(N)
            maxInterval = Math.max(maxInterval, interval[1]);
        }
        // we will make use of Sweepline Algorithm
        int[] diff = new int[maxInterval + 2]; // SC: O(T)
        for (int[] interval : intervals) { // TC: O(N)
            diff[interval[0]] += 1;
            diff[interval[1] + 1] -= 1;
        }
        int count = 0;
        int maxPowNum = -1;
        for (int i = 0; i <= maxInterval; i++) { // TC: O(T)
            count += diff[i];
            if (count >= k) {
                maxPowNum = i;
            }
        }
        return maxPowNum;
    }

    /**
     * Approach I : Using Hashing Approach
     * 
     * TC: O(N x T) + O(T) ~ O(N x T)
     * SC: O(T)
     * 
     * where T = Max(intervals) - Min(intervals)
     * 
     * Time Limit Exceeded (1110 / 1115 testcases passed)
     */
    public int powerfulIntegerBruteForce(int[][] intervals, int k) {
        int n = intervals.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(T)
        for (int i = 0; i < n; i++) { // TC : O(N)
            int start = intervals[i][0];
            int end = intervals[i][1];
            for (int j = start; j <= end; j++) { // TC: O(T)
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }
        int maxPowNum = -1;
        for (Integer key : map.keySet()) { // TC: O(T)
            if (map.get(key) >= k) {
                maxPowNum = Math.max(maxPowNum, key);
            }
        }
        return maxPowNum;
    }
}
