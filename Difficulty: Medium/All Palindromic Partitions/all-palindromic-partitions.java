class Solution {
    /**
     * Approach : Using Recursion + Backtracking Approach
     * 
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    public ArrayList<ArrayList<String>> palinParts(String s) {
        int n = s.length();
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> current = new ArrayList<String>();
        solveRecursion(0, n, s, current, result);
        return result;
    }
    
    /**
     * Using Recursion + Backtracking Approach
     * 
     * TC: O(N x 2 ^ N)
     * SC: O(N)
     */
    private void solveRecursion(int idx, int n, String s, ArrayList<String> current,
        ArrayList<ArrayList<String>> result) {
        // Base Case
        if (idx == n) {
            result.add(new ArrayList<String>(current));
            return;
        }
        // Recursion Calls
        for (int i = idx; i < n; i++) { // TC: O(N)
            String temp = s.substring(idx, i + 1);
            if (isPalindrome(temp)) { // TC: O(N)
                current.add(temp); // modify
                solveRecursion(i + 1, n, s, current, result); // explore
                current.remove(current.size() - 1); // backtrack
            }
        }
    }

    /**
     * Using Two Pointers Approach
     * 
     * TC: O(N / 2) ~ O(N)
     * SC: O(1)
     */
    private boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
