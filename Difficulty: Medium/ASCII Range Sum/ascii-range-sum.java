class Solution {
    /**
     * Approach : Using Hasing + Array pre-processing Approach
     * 
     * TC: O(N) + O(N) + O(26) ~ O(N)
     * SC: O(N) + O(N) + O(26) ~ O(N)
     */
    public ArrayList<Integer> asciirange(String s) {
        int n = s.length();
        int[] mapping = new int[n]; // SC: O(N)
        Map<Integer, int[]> map = new HashMap<Integer, int[]>(); // SC: O(26)
        for (int i = 0; i < n; i++) { // TC: O(N)
            int ch = s.charAt(i) - 'a';
            mapping[i] = ch;
            if (!map.containsKey(ch)) {
                map.put(ch, new int[] { i, -1 });
            } else {
                map.get(ch)[1] = i;
            }
        }
        int[] prefixSum = new int[n]; // SC: O(N)
        prefixSum[0] = mapping[0];
        for (int i = 1; i < n; i++) { // TC: O(N)
            prefixSum[i] = prefixSum[i - 1] + mapping[i];
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Integer key : map.keySet()) { // TC: O(26)
            int[] value = map.get(key);
            if (value[1] != -1) {
                int size = value[1] - value[0] - 1;
                int sum = (size * 97) + (prefixSum[value[1] - 1] - prefixSum[value[0]]);
                if (sum > 0) {
                    result.add(sum);
                }
            }
        }
        return result;
    }
}
