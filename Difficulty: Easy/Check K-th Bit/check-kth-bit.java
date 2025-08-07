class CheckBit {
    /**
     * Approach : Using Bit-Manipulation Approach
     * 
     * TC: O(1)
     * SC: O(1)
     */
    static boolean checkKthBit(int n, int k) {
        return ((n >> k) & 1) == 1;
    }
}
