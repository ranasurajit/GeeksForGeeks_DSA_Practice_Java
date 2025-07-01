
class Solution {
    /**
     * Approach II : Using Memoization (Top-Down DP) Approach
     * 
     * TC: O(N x S) + O(N)
     * SC: O(N x S) + O(N)
     *
     * Accepted (1111 / 1111 testcases passed)
     */
    int countPartitions(int[] arr, int d) {
        int n = arr.length;
        int total = 0;
		for (int num : arr) { // TC: O(N)
			total += num;
		}
		/**
		 * we have to find two partitions such that:
		 * |s1 - s2| = d
		 *  s1 + s2 = total
		 * so s1 = (d + total) / 2, so the problem 
		 * reduces to find the count of subsets with target = s1 = (d + total) / 2
		 */
		int calculation = d + total;
		if ((calculation & 1) != 0) {
			return 0;
		}
		int target = calculation / 2;
		int[][] memo = new int[n + 1][target + 1]; // SC: O(N x S)
		for (int[] mem : memo) {
		    Arrays.fill(mem, -1);
		}
		return solveMemoization(n - 1, arr, target, memo); // TC: O(N x S), SC: O(N)
    }
    
    /**
     * Using Memoization Approach
     * 
     * TC: O(N x S)
     * SC: O(N)
     */
    private int solveMemoization(int idx, int[] arr, int target, int[][] memo) {
        // Base Case
        if (idx < 0) {
            return target == 0 ? 1 : 0;
        }
        // Memoization Check
        if (memo[idx][target] != -1) {
            return memo[idx][target];
        }
        // Recursive Calls
        int pick = 0;
        int skip = 0;
        if (arr[idx] <= target) {
            // we can choose to pick or skip
            pick = solveMemoization(idx - 1, arr, target - arr[idx], memo);
            skip = solveMemoization(idx - 1, arr, target, memo);
        } else {
            // we cannot pick at all
            skip = solveMemoization(idx - 1, arr, target, memo);
        }
        return memo[idx][target] = pick + skip;
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     *
     * Time Limit Exceeded (1010 / 1111 testcases passed)
     */
    int countPartitionsRecursion(int[] arr, int d) {
        int n = arr.length;
        int total = 0;
		for (int num : arr) {
			total += num;
		}
		/**
		 * we have to find two partitions such that:
		 * |s1 - s2| = d
		 *  s1 + s2 = total
		 * so s1 = (d + total) / 2, so the problem 
		 * reduces to find the count of subsets with target = s1 = (d + total) / 2
		 */
		int calculation = d + total;
		if ((calculation & 1) != 0) {
			return 0;
		}
		int target = calculation / 2;
		return solveRecursion(n - 1, arr, target);
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private int solveRecursion(int idx, int[] arr, int target) {
        // Base Case
        if (idx < 0) {
            return target == 0 ? 1 : 0;
        }
        // Recursive Calls
        int pick = 0;
        int skip = 0;
        if (arr[idx] <= target) {
            // we can choose to pick or skip
            pick = solveRecursion(idx - 1, arr, target - arr[idx]);
            skip = solveRecursion(idx - 1, arr, target);
        } else {
            // we cannot pick at all
            skip = solveRecursion(idx - 1, arr, target);
        }
        return pick + skip;
    }
}
