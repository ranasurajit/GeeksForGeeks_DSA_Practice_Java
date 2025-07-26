class Solution {
    /**
     * Approach II : Using Moore's Voting Approach
     * 
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(1)
     */
    public ArrayList<Integer> findMajority(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> majority = new ArrayList<Integer>();
        /**
         * There can be maximum of two elements which may occur > n / 3 times
         */
        int count1 = 0;
        int element1 = -1;
        int count2 = 0;
        int element2 = -1;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] == element1) {
                count1++;
            } else if (arr[i] == element2) {
                count2++;
            } else if (count1 == 0) {
                count1 = 1;
                element1 = arr[i];
            } else if (count2 == 0) {
                count2 = 1;
                element2 = arr[i];
            } else {
                count1--;
                count2--;
            }
        }
        // check if element1 is our majority element
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr[i] == element1) {
                count1++;
            } else if (arr[i] == element2) {
                count2++;
            }
        }
        if (count1 > n / 3) {
            majority.add(element1);
        }
        if (count2 > n / 3) {
            if (element2 > element1) {
                majority.add(element2);
            } else {
                majority.add(0, element2);
            }
        }
        return majority;
    }

    /**
     * Approach I : Using Hashing Approach
     * 
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(N)
     */
    public ArrayList<Integer> findMajorityHashing(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> majority = new ArrayList<Integer>();
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }
        for (Integer key : freqMap.keySet()) { // TC: O(N)
            if (freqMap.get(key) > n / 3) {
                majority.add(key);
            }
        }
        return majority;
    }
}
