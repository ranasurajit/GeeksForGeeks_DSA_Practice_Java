/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    /**
     * Approach : Using DFS Approach
     * 
     * TC: O(N)
     * SC: O(H)
     * 
     * where H = height of BST ~ N in worst case Skewed Tree
     */
    public boolean isDeadEnd(Node root) {
        int[] range = { 1, (int) 1e5 };
        return dfsTree(root, range);
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(N)
     * SC: O(H)
     */
    private boolean dfsTree(Node root, int[] range) {
        // Base Case
        if (root == null) {
            return false;
        }
        if (range[0] == range[1]) {
            // we got a dead end leaf node
            return true;
        }
        // Recursion Calls
        return dfsTree(root.left, new int[] { range[0], root.data -1 }) ||
            dfsTree(root.right, new int[] { root.data + 1, range[1] });
    }
}
