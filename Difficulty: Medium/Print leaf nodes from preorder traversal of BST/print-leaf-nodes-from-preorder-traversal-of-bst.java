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
        // push the root node into Stack as we know preorder stores the root at index '0'
        st.push(preorder[0]);
        for (int i = 1; i < n; i++) { // TC: O(N)
            if (preorder[i] < st.peek()) {
                st.push(preorder[i]);
            } else {
                // switch from left sub-tree to right sub-tree
                int temp = st.pop();
                // count of nodes after there is a switch from left sub-tree to right sub-tree
                int count = 1;
                while (!st.isEmpty() && preorder[i] > st.peek()) {
                    st.pop();
                    count++;
                }
                // for temp node to be leaf count should be 2 or more
                // if count <= 1 then temp node will be root of the sub-tree and not the leaf
                if (count > 1) {
                    leafs.add(temp);
                }
                st.push(preorder[i]);
            }
        }
        /**
         * lastly added node to Stack is also a leaf node and 
         * denotes a leaf node at the right sub-tree
         */
        leafs.add(st.pop());
        return leafs;
    }
}
