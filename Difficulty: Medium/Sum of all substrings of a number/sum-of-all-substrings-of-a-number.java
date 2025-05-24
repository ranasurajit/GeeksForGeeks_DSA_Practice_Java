class Solution {
    /**
     * Approach : Using Recursion Approach
     * 
     * TC: O(2 ^ N + N ^ 2) ~ O(2 ^ N)
     * SC: O(N ^ 2 + 2 x N) ~ O(N ^ 2)
     */
    public static int sumSubstrings(String s) {
        int n = s.length();
        /**
         * we are generating all contiguous substrings of a string of length N.
         * Number of substrings = N x (N + 1) / 2 ~ N ^ 2 Strings
         */
        List<String> result = new ArrayList<String>(); // SC: O(N ^ 2)
        StringBuilder sb = new StringBuilder();        // SC: O(N)
        solveRecursion(0, -1, n, s, sb, result);       // TC: O(2 ^ N)
        double sum = 0;
        for (String p : result) { // TC: O(N ^ 2)
            sum += Double.parseDouble(p);
        }
        return (int) sum;
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(2 ^ N)
     * SC: O(N)
     */
    private static void solveRecursion(int idx, int prevIdx, int n, String s,
        StringBuilder sb, List<String> result) {
        // Base Case
        if (idx == n) {
            if (sb.length() > 0) {
                result.add(sb.toString());
            }
            return;
        }
        // Recursion Calls
        if (prevIdx == -1 || idx == prevIdx + 1) {
            // we can choose to take or not take the character at current index 'idx'
            // not take
            solveRecursion(idx + 1, prevIdx, n, s, sb, result);
            // take
            sb.append(s.charAt(idx));
            solveRecursion(idx + 1, idx, n, s, sb, result);
            sb.setLength(sb.length() - 1); // backtrack to explore other possibilities
        } else {
            // we cannot take the character at current index 'idx'
            solveRecursion(idx + 1, prevIdx, n, s, sb, result);
        }
    }
}
