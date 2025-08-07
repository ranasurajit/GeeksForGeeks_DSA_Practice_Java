class Solution {
    /**
     * Approach : Using Bit-Manipulation Approach
     * 
     * TC: O(1)
     * SC: O(1)
     */
    static boolean isEven(int n) {
        return (n & 1) == 0;
    }
}
