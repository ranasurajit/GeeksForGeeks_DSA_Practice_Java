class Solution {
    /**
     * Approach : Using Monotonic Stack Approach to Find Next Greater Element
     * 
     * TC: O(N) + O(2 x N) + O(N) ~ O(N)
     * SC: O(2 x N) + O(2 x N) ~ O(N)
     */
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] nums = new int[2 * n];
        for (int i = 0; i < n; i++) { // TC: O(N)
            nums[i] = arr[i];
            nums[n + i] = arr[i];
        }
        Stack<Integer> st = new Stack<Integer>();    // SC: O(2 x N)
        Stack<Integer> revSt = new Stack<Integer>(); // SC: O(2 x N)
        int i = 2 * n - 1;
        while (i >= 0) { // TC: O(2 x N)
            while (!st.isEmpty() && nums[i] >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                revSt.push(-1);
            } else {
                revSt.push(st.peek());
            }
            st.push(nums[i]);
            i--;
        }
        while (!revSt.isEmpty() && n > 0) { // TC: O(N)
            result.add(revSt.pop());
            n--;
        }
        return result;
    }
}
