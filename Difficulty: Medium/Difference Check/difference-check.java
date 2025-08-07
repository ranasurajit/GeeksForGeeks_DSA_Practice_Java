class Solution {
    /**
     * Approach : Using Sorting Approach
     * 
     * TC: O(N) + O(N x log(N)) + O(N) ~ O(N x log(N))
     * SC: O(N)
     */
    public int minDifference(String[] arr) {
        int n = arr.length;
        int[] timings = new int[n]; // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            String[] splits = arr[i].split(":");
            int hour = Integer.valueOf(splits[0]);
            int min = Integer.valueOf(splits[1]);
            int sec = Integer.valueOf(splits[2]);
            timings[i] = 3600 * hour + min * 60 + sec;
        }
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(timings); // TC: O(N x log(N))
        int last = timings[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            int currentDiff = timings[i] - timings[i - 1];
            minDiff = Math.min(minDiff, currentDiff);
        }
        int circularDiff = 86400 - timings[n - 1] + timings[0];
        return Math.min(minDiff, circularDiff);
    }
}
