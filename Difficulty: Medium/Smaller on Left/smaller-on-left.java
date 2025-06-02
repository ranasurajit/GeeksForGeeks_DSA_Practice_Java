class Solution {
    /**
     * Approach II : Using Stack Approach
     * 
     * As we have inner loop j which is dependent on i as j starts backwards 
     * from (i - 1) to 0 so we can reduce the time complexity to 
     * Linear O(N) by using Stack data-structure
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public int[] leftSmaller(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (st.isEmpty()) {
                nse[i] = -1;
            } else {
                while (!st.isEmpty() && arr[i] <= st.peek()) {
                    st.pop();
                }
                if (st.isEmpty()) {
                    nse[i] = -1;
                } else {
                    nse[i] = st.peek();
                }
            }
            st.push(arr[i]);
        }
        return nse;
    }

    /**
     * Approach I : Using Brute-Force Approach
     * 
     * TC: O(N ^ 2)
     * SC: O(1)
     */
    public int[] leftSmallerBruteForce(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        nse[0] = -1;
        for (int i = 1; i < n; i++) { // TC: O(N)
            boolean isFound = false;
            for (int j = i - 1; j >= 0; j--) { // TC: O(N)
                if (arr[j] < arr[i]) {
                    isFound = true;
                    nse[i] = arr[j];
                    break;
                }
            }
            if (!isFound) {
                nse[i] = -1;
            }
        }
        return nse;
    }
}
