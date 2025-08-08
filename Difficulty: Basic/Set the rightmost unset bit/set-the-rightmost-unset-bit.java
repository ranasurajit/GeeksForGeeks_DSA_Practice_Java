// User function Template for Java
class Solution {
    /**
     * Approach : Using Bit-Manipulation (Brute-Force) Approach
     * 
     * TC: O(32) ~ O(1)
     * SC: O(1)
     */
    static int setBit(int n) {
        int idx = -1;
        for (int i = 0; i < 32; i++) { // TC: O(32)
            int ithBit = ((n >> i) & 1);
            if (ithBit != 1) {
                idx = i;
                break;
            }
        }
        return (n | (1 << idx));
    }
}
