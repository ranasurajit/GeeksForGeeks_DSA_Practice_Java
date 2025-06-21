class Solution {
    /**
     * Approach: Using Two Pointers Approach
     * 
     * TC: O(N + N1 + N2) ~ O(2 x N) ~ O(N)
     * SC: O(N1 + N2) ~ O(N)
     */
    public int catchThieves(char[] arr, int k) {
        int n = arr.length;
        List<Integer> tIndex = new ArrayList<Integer>(); // SC: O(N1)
        List<Integer> pIndex = new ArrayList<Integer>(); // SC: O(N2)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] == 'T') {
                tIndex.add(i);
            } else {
                pIndex.add(i);
            }
        }
        int i = 0; // pointer at the start of tIndex
        int j = 0; // pointer at the start of pIndex
        int caught = 0;
        while (i < tIndex.size() && j < pIndex.size()) { // TC: O(N1 + N2)
            if (Math.abs(tIndex.get(i) - pIndex.get(j)) <= k) {
                caught++;
                i++;
                j++;
            } else if (pIndex.get(j) < tIndex.get(i)) {
                // police cannot reach so next police would try to catch the thief
                j++;
            } else {
                i++;
            }
        }
        return caught;
    }
}
