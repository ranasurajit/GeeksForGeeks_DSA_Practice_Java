class Solution {
    /**
     * Approach : Using Stack Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public ArrayList<Integer> leafNodes(int[] preorder) {
        int n = preorder.length;
        ArrayList<Integer> leafs = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<Integer>(); // SC: O(N)
        st.push(preorder[0]);
        for (int i = 1; i < n; i++) { // TC: O(N)
            if (preorder[i] < st.peek()) {
                st.push(preorder[i]);
            } else {
                int temp = st.pop();
                int count = 1;
                while (!st.isEmpty() && preorder[i] > st.peek()) {
                    st.pop();
                    count++;
                }
                if (count > 1) {
                    leafs.add(temp);
                }
                st.push(preorder[i]);
            }
        }
        leafs.add(preorder[n - 1]);
        return leafs;
    }
}
