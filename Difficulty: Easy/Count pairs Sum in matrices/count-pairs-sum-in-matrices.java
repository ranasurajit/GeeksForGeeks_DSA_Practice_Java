class Solution {
    /**
     * Approach : Using Hashing Approach
     * 
     * TC: O(2 x N x N) ~ O(N x N)
     * SC: O(N x N)
     */
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        int n = mat1.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // SC: O(N x N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 0; j < n; j++) { // TC: O(N)
                map.put(mat1[i][j], map.getOrDefault(mat1[i][j], 0) + 1);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 0; j < n; j++) { // TC: O(N)
                int diff = x - mat2[i][j];
                if (map.containsKey(diff)) {
                    count += map.get(diff);
                }
            }
        }
        return count;
    }
}
