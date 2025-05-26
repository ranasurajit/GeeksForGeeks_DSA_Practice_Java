class Solution {
    /**
     * Approach II : Using Hashing Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     * 
     * Accepted - Test Cases Passed: (1112 /1112)
     */
    public boolean canPair(List<Integer> arr, int k) {
        int n = arr.size();
        // to find pairs, the size of array 'arr' should be even
        if ((n & 1) != 0) {
            return false;
        }
        if (k == 1) {
            return true;
        }
        /**
         * By mathematical proof, it can be shown that two pairs will be such that
         * (arr[i] % k) + (arr[j] % k) = k
         * 
         * Now we will replace all arr[i] with arr[i] % k then the problem
         * will be reduced to check if all pairs such that
         * 
         * arr[i] + arr[j] = k
         */
        Set<Integer> set = new HashSet<Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            int num1 = arr.get(i) % k;
            int num2 = num1 == 0 ? 0 : k - num1;
            if (set.contains(num2)) {
                set.remove(num1);
                set.remove(num2);
            } else {
                set.add(num1);
            }
        }
        return set.isEmpty();
    }
    
    /**
     * Approach I : Using Brute-Force Approach
     * 
     * TC: O(N ^ 2 + N) ~ O(N ^ 2)
     * SC: O(1)
     * 
     * Time limit exceeded - Test Cases Passed: (1110 /1112)
     */
    public boolean canPairBruteForce(List<Integer> arr, int k) {
        int n = arr.size();
        // to find pairs, the size of array 'arr' should be even
        if ((n & 1) != 0) {
            return false;
        }
        for (int i = 0; i < n - 1; i++) { // TC: O(N)
            if (arr.get(i) == -1) {
                continue;
            }
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                if (arr.get(j) == -1) {
                    continue;
                }
                if ((arr.get(i) + arr.get(j)) % k == 0) {
                    // marking that the elements are used already to form a pair
                    arr.set(i, -1);
                    arr.set(j, -1);
                }
            }
        }
        // check if any element remains unused
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (arr.get(i) != -1) {
                return false;
            }
        }
        return true;
    }
}
