// User function Template for Java

class Solution {
    /**
     * Approach : Using Sorting + Simulation Approach
     * 
     * TC: O(N) + O(N x log(N)) + O(N) ~ O(N x log(N))
     * SC: O(2 x N) ~ O(N)
     */
    static String isKSortedArray(int arr[], int n, int k) {
        int[][] indexArr = new int[n][2]; // SC: O(2 x N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            indexArr[i] = new int[] { arr[i], i };
        }
        Arrays.sort(indexArr, (a, b) -> a[0] - b[0]); // TC: O(N x log(N))
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (Math.abs(i - indexArr[i][1]) > k) {
                return "No";
            }
        }
        return "Yes";
    }
}
