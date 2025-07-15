class Solution {
    /**
     * Approach : Using Mathematical Simulation
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public boolean divby13(String s) {
        int n = s.length();
        int rem = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            int num = (s.charAt(i) - '0') + rem * 10;
            rem = num % 13;
        }
        return rem == 0;
    }
}
