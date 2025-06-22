class Solution {
    /**
     * Approach II : Using Tabulation Approach
     * 
     * TC: O(N ^ 2)
     * SC: O(N ^ 2)
     * 
     * Accepted : Test Cases Passed: (1121 /1121)
     */
    public ArrayList<Integer> largestSubset(int[] arr) {
        int n = arr.length;
        Integer[] temp = new Integer[n];
        for (int i = 0; i < n; i++) temp[i] = arr[i];
        Arrays.sort(temp, Collections.reverseOrder());
        for (int i = 0; i < n; i++) arr[i] = temp[i];

        int[] memo = new int[n];
        int[] parent = new int[n];
        Arrays.fill(memo, -1);
        Arrays.fill(parent, -1);

        int maxSize = 0;
        int lastIndex = 0;

        for (int i = 0; i < n; i++) {
            int size = lds(arr, memo, parent, i);
            if (size > maxSize) {
                maxSize = size;
                lastIndex = i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = lastIndex; i >= 0; i = parent[i]) {
            result.add(arr[i]);
            if (parent[i] == -1) break;
        }

        return result;
    }
    
    public int lds(int[] arr, int[] memo, int[] parent, int i) {
        if (memo[i] != -1) {
            return memo[i];
        }

        int maxLength = 1;
        int bestParent = -1;

        for (int j = 0; j < i; j++) {
            if (arr[j] % arr[i] == 0) {
                int length = lds(arr, memo, parent, j) + 1;
                if (length > maxLength) {
                    maxLength = length;
                    bestParent = j;
                }
            }
        }

        memo[i] = maxLength;
        parent[i] = bestParent;
        return maxLength;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 x N x 2 ^ N + N x log(N)) ~ O(N x 2 ^ N)
     * SC: O(N x 2 ^ N + N) ~ O(N x 2 ^ N)
     * 
     * Time limit exceeded : Test Cases Passed: (1110 /1121)
     */
    public ArrayList<Integer> largestSubsetRecursion(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr); // TC: O(N x log(N))
        ArrayList<Integer> result = new ArrayList<Integer>(); // SC: O(N)
        ArrayList<ArrayList<Integer>> subsets = 
            new ArrayList<ArrayList<Integer>>(); // SC: O(N x 2 ^ N)
        solveRecursion(0, -1, n, arr, result, subsets); // TC: O(N x 2 ^ N), SC: O(N)
        int maxLength = 0;
        for (ArrayList<Integer> list : subsets) { // TC: O(N x 2 ^ N)
            if (list.size() >= maxLength) {
                result = list;
                maxLength = list.size();
            }
        }
        return result;
    }

    /**
     * Using Recursion Approach
     * 
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    private void solveRecursion(int idx, int prev, int n, int[] arr, 
        ArrayList<Integer> result, ArrayList<ArrayList<Integer>> subsets) {
        // Base Case
        if (idx == n) {
            subsets.add(new ArrayList<Integer>(result));
            return;
        }
        // Recursion Calls
        if (prev == -1 || arr[idx] % prev == 0) {
            // we can choose to take or not take the element at index 'idx'
            // take
            result.add(arr[idx]);
            solveRecursion(idx + 1, arr[idx], n, arr, result, subsets);
            result.remove(result.size() - 1);
            // not take
            // result.remove(result.size() - 1);
            solveRecursion(idx + 1, prev, n, arr, result, subsets);
        } else {
            // we cannot take the element at index 'idx'
            solveRecursion(idx + 1, prev, n, arr, result, subsets);
        }
    }
}
