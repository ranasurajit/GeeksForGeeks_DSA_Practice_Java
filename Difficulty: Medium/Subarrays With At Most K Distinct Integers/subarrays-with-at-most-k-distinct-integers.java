class Solution {
    private static final int MOD = (int) 1e9 + 7;

    /**
     * Approach : Using Sliding Window (Variable Size) Approach
     * 
     * TC: O(N)
     * SC: O(K)
     */
    public int countAtMostK(int arr[], int k) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>(); // SC: O(K)
        int count = 0;
        while (j < n) { // TC: O(N)
            freqMap.put(arr[j], freqMap.getOrDefault(arr[j], 0) + 1);
            while (i < n && freqMap.size() > k) {
                // remove computation from index 'i'
                freqMap.put(arr[i], freqMap.get(arr[i]) - 1);
                if (freqMap.get(arr[i]) == 0) {
                    freqMap.remove(arr[i]);
                }
                i++;
            }
            if (freqMap.size() <= k) {
                count = ((count % MOD) + (j - i + 1)) % MOD;
            }
            j++;
        }
        return count % MOD;
    }
}
