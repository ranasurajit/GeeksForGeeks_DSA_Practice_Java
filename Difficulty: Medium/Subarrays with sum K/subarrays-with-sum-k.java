class Solution {
    /**
     * Approach : Using Hashing Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public int cntSubarrays(int[] arr, int k) {
        int n = arr.length;
        int sum = 0;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        map.put(0, 1);
        int count = 0;
        while (i < n) { // TC: O(N)
            sum += arr[i];
            int diff = sum - k;
            if (map.containsKey(diff)) {
                count += map.get(diff);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            i++;
        }
        return count;
    }
}
