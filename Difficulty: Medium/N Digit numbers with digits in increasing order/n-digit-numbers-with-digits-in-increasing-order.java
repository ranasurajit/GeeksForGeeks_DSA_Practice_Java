
class Solution {
    /**
     * Approach : Using Recursion + Backtracking Approach
     * 
     * TC: O(9 ^ N)
     * SC: O(N)
     */
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n == 1) {
            for (int i = 0; i <= 9; i++) { // TC: O(1)
                result.add(i);
            }
        } else {
            solveBacktrack(0, -1, n, new StringBuilder(), result); // TC: O(9 ^ N), SC: O(N)
        }
        return result;
    }
    
    /**
     * Using Recursion + Backtracking Approach
     * 
     * TC: O(9 ^ N)
     * SC: O(N)
     */
    private static void solveBacktrack(int index, int prev, int n, StringBuilder sb,
        ArrayList<Integer> result) {
        // Base Case
        if (index == n) {
            if (sb.length() == n) {
                result.add(Integer.valueOf(sb.toString()));
            }
            return;
        }
        // Recursion Calls
        for (int i = 1; i <= 9; i++) {
            if (prev == -1 || i > prev) {
                sb.append(i);
                // explore
                solveBacktrack(index + 1, i, n, sb, result);
                // backtrack
                sb.setLength(sb.length() - 1);
            }
        }
    }
}
