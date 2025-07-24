class Solution {
    /**
     * Approach : Using Simulation Approach
     * 
     * TC: O(P + Q)
     * SC: O(1)
     * 
     * where P = size(left), Q = size(right)
     */
    public int getLastMoment(int n, int left[], int right[]) {
        /**
         * Collision has no effect on timings so it is as good
         * as ants continuing the jorney to reach either side
         * of the wooden plank, so we need to find the maximum
         * units travelled by any ant (at speed of 1 unit / sec)
         * so, the maximum unit = time of the last ant to fall 
         * out the plank
         */
        int maxDist = 0;
        int p = left.length;
        int q = right.length;

        for (int i = 0; i < p; i++) { // TC: O(P)
            maxDist = Math.max(maxDist, left[i]);
        }
        for (int i = 0; i < q; i++) { // TC: O(Q)
            maxDist = Math.max(maxDist, n - right[i]);
        }
        return maxDist;
    }
}
