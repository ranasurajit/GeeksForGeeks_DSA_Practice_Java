// User function Template for Java

class Solution {
    /**
     * Approach : Using Brute-Force Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public void immediateSmaller(int arr[]) {
        int n = arr.length;
        int[] nse = new int[n]; // SC: O(N)
        nse[n - 1] = -1;
        for (int i = n - 2; i >=0; i--) { // TC: O(N)
            if (arr[i + 1] < arr[i]) {
                nse[i] = arr[i + 1];
            } else {
                nse[i] = -1;
            }
        }
        for (int i = 0; i < n; i++) {
            arr[i] = nse[i];
        }
    }
}
