class Solution {
    /**
     * Approach : Using Simulation Approach
     * 
     * TC: O(1)
     * SC: O(1)
     */
    public void calculateMultiples(int n) {
        int factor = 10;
        while (factor > 0) { // TC: O(10) ~ O(1)
            System.out.print(n * factor + " ");
            factor--;
        }
    }
}
