

class Solution {
    // Function to find the largest number after k swaps.
    /**
     * Approach : Recursion + Backtracking Approach
     * 
     * Number of Nodes = N...1 = N x (N + 1) / 2 ~ N ^ 2
     * 
     * TC: O(N ^ 2) - Ammorized Time Complexity
     * SC: O(N ^ 2 + N + K)
     */
    public String findMaximumNum(String s, int k) {
        char[] chars = s.toCharArray(); // SC: O(N)
        String[] maxValue = { s };
        solveBacktrack(0, chars, k, maxValue); // TC: O(N ^ 2), SC: O(N ^ 2 + K)
        return maxValue[0];
    }
    
    /**
     * Recursion + Backtracking Approach
     * 
     * Number of Nodes = N...1 = N x (N + 1) / 2 ~ N ^ 2
     * 
     * TC: O(N ^ 2) - Ammorized Time Complexity
     * SC: O(N ^ 2 + K)
     */
    private void solveBacktrack(int index, char[] chars, int k, String[] maxValue) {
        // Base Case
        if (k == 0 || index == chars.length - 1) {
            return;
        }
        for (int i = index + 1; i < chars.length; i++) { // TC: O(N)
            int max = chars[i] - '0';
            for (int j = i; j < chars.length; j++) {
                max = Math.max(max, (chars[j] - '0'));
            }
            if ((chars[index] - '0') < (chars[i] - '0') && (chars[i] - '0') == max) {
                // swap the characters at indices 'index' and 'i'
                swap(chars, index, i);
                String current = String.valueOf(chars);
                if (current.compareTo(maxValue[0]) > 0) {
                    maxValue[0] = current;
                }
                solveBacktrack(index + 1, chars, k - 1, maxValue);
                // backtrack - undo swap to explore other possibilities
                swap(chars, index, i);
            } else {
                solveBacktrack(index + 1, chars, k, maxValue);
            }
        }
    }

    /**
     * Swap Approach
     * 
     * TC: O(1)
     * SC: O(1)
     */
    private void swap(char[] chars, int a, int b) {
        char temp = chars[b];
        chars[b] = chars[a];
        chars[a] = temp;
    }
}
