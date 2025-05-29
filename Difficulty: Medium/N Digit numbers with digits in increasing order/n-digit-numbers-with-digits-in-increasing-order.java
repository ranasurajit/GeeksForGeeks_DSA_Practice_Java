class Solution {
    /**
     * Approach II : Using Recursion + Backtracking Approach
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
            return result;
        }
        int[] num = { 0 };
        solve(0, n, num, result); // TC: O(9 ^ N), SC: O(N)
        return result;
    }
    
    /**
     * Using Recursion + Backtracking Approach
     * 
     * TC: O(9 ^ N)
     * SC: O(N)
     */
    private static void solve(int lastDigit, int n, int[] num, ArrayList<Integer> result) {
        // Base Case
        if (n == 0) {
            result.add(num[0]);
            return;
        }
        // Recursion Calls
        for (int i = lastDigit + 1; i <= 9; i++) {
            // modify
            num[0] = num[0] * 10 + i;
            // explore
            solve(i, n - 1, num, result);
            // backtrack
            num[0] = num[0] / 10;
        }
    }

    /**
     * Approach I : Using Recursion + Backtracking Approach
     * 
     * TC: O(9 ^ N)
     * SC: O(N)
     */
    public static ArrayList<Integer> increasingNumbersApproachI(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n == 1) {
            for (int i = 0; i <= 9; i++) { // TC: O(1)
                result.add(i);
            }
            return result;
        }
        solveBacktrack(0, -1, n, new StringBuilder(), result); // TC: O(9 ^ N), SC: O(N)
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
