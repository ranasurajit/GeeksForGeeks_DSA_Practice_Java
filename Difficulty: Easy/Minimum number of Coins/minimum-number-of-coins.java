// User function Template for Java

class Solution {
    private static final int[] currencies = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
    private static int minCoins = Integer.MAX_VALUE;
    private static List<Integer> result = new ArrayList<Integer>();
    
    /**
     * Approach II : Using Greedy Approach
     * 
     * TC: O(M)
     * SC: O(1)
     * 
     * where M = number of types of denominations in currencies
     */
    static List<Integer> minPartition(int N) {
        /**
         * A coin system is canonical if the greedy algorithm always 
         * yields the optimal solution (minimum number of coins) 
         * for all values of N. So Greedy will work in this
         */
        List<Integer> combinations = new ArrayList<Integer>();
        int n = currencies.length;
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            while (currencies[i] <= N) {
                N -= currencies[i];
                combinations.add(currencies[i]);
            }
        }
        return combinations;
    }
    
    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ M) + O(P x log(P)) ~ O(2 ^ M)
     * SC: O(M)
     * 
     * where M = number of types of denominations in currencies
     */
    static List<Integer> minPartitionRecursion(int N) {
        solveRecursion(0, N, new ArrayList<Integer>()); // TC: O(2 ^ M)
        Collections.sort(result, Collections.reverseOrder()); // TC: O(P x log(P))
        return result;
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(2 ^ M)
     * SC: O(M)
     */
    private static void solveRecursion(int idx, int N, List<Integer> combinations) {
        // Base Case
        if (N == 0) {
            if (combinations.size() < minCoins) {
                minCoins = combinations.size();
                result = new ArrayList<Integer>(combinations);
            }
            return;
        }
        if (idx == currencies.length || combinations.size() >= minCoins) {
            return;
        }
        // Recursive Calls
        // skip
        solveRecursion(idx + 1, N, combinations);
        if (currencies[idx] <= N) {
            // pick
            combinations.add(currencies[idx]);
            solveRecursion(idx, N - currencies[idx], combinations);
            combinations.remove(combinations.size() - 1); // backtrack
        }
    }
}
