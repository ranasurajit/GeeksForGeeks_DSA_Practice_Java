// User function Template for Java

class Solution {
    /**
     * Approach : Using LIS and Previous Index Tracking Array Approach
     * 
     * TC: O(N) + O(N) + O(N) ~ O(N)
     * SC: O(N) + O(N) ~ O(N)
     */
    public ArrayList<Integer> getLIS(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> lis = new ArrayList<Integer>();
        // we are going to store maximum LIS length possible till index 'i' in dp[i]
        int[] dp = new int[n]; // SC: O(N)
        Arrays.fill(dp, 1); // 1 is the minimum length of LIS
        int maxLength = 1;
        // we need an ArrayList to track the previdx at every index i which forms LIS
        ArrayList<Integer> track = new ArrayList<Integer>(); // SC: O(N)
        int lastPrevIndex = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            track.add(i); // minimum possibility of LIS is the same index i
            for (int prevIdx = 0; prevIdx < i; prevIdx++) {
                if (arr[i] > arr[prevIdx] && dp[prevIdx] + 1 > dp[i]) {
                    dp[i] = dp[prevIdx] + 1;
                    // we have stored a greater length so we can update the track ArrayList
                    track.set(i, prevIdx);
                }
            }
            if (maxLength < dp[i]) {
                maxLength = dp[i];
                // we need to update the lastPrevIndex here
                lastPrevIndex = i;
            }
        }
        lis.add(arr[lastPrevIndex]); // as this is surely the element in LIS
        while (track.get(lastPrevIndex) != lastPrevIndex) { // TC: O(N)
            lastPrevIndex = track.get(lastPrevIndex);
            lis.add(arr[lastPrevIndex]);
        }
        Collections.reverse(lis); // TC: O(N)
        return lis;
    }
}
