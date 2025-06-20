class Solution {
    public boolean validgroup(int[] arr, int k) {
        int n = arr.length;
        if (n % k != 0) {
            return false;
        }
        // We need to sort the array 'arr' to check if we have consective integers in it
        Arrays.sort(arr); // TC: O(N x log(N))
        // boolean[] visited = new boolean[n];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            int freq = map.getOrDefault(arr[i], 0); // number of groups to form
            if (freq == 0) {
                continue;
            }
            for (int j = 0; j < k; j++) { // TC: O(K)
                int current = arr[i] + j;
                int currentFreq = map.getOrDefault(current, 0);
                if (currentFreq < freq) {
                    return false;
                }
                map.put(current, currentFreq - freq);
                if (currentFreq - freq == 0) {
                    map.remove(current);
                }
            }
        }
        return true;
    }
}
