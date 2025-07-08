class Solution {
    /**
     * Approach : Using Monotonic Stack Approach
     * 
     * TC: O(N) + O(N) + O(N) ~ O(N)
     * SC: O(N) + O(N) + O(N) ~ O(N)
     */
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
        int[] leftMinElements = getNumberOfMinimumInLeft(arr, n, st); // TC: O(N), SC: O(N)
        st.clear();
        int[] rightMinElements = getNumberOfMinimumInRight(arr, n, st); // TC: O(N), SC: O(N)
        /**
         * we need to calculate for any element arr[i] how many sub-arrays are present
         * in the left and right of it where it can contribute as the minimum value
         */
        int count = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            count += leftMinElements[i] * rightMinElements[i] * arr[i];
        }
        return count;
    }
    
    /**
     * Using Monotonic Stack Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    private int[] getNumberOfMinimumInLeft(int[] arr, int n, Stack<Integer> st) {
        int[] numMinLeft = new int[n]; // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            numMinLeft[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }
        return numMinLeft;
    }
    
    /**
     * Using Monotonic Stack Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    private int[] getNumberOfMinimumInRight(int[] arr, int n, Stack<Integer> st) {
        int[] numMinRight = new int[n]; // SC: O(N)
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            numMinRight[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }
        return numMinRight;
    }
}
