class Solution {
    /**
     * Approach : Using Sliding Window (Variable Size) Approach
     * 
     * TC: O(N)
     * SC: O(2) ~ O(1) as Map will contain atmost  two distinct integers / keys
     */
    public int totalElements(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(2)
        int maxLength = 0;
        while (j < n) { // TC: O(N)
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            while (i < n && map.size() > 2) {
                // remove calculation from index 'i'
                map.put(arr[i], map.get(arr[i]) - 1);
                if (map.get(arr[i]) == 0) {
                    map.remove(arr[i]);
                }
                i++;
            }
            if (map.size() <= 2) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
            j++;
        }
        return maxLength;
    }
}
