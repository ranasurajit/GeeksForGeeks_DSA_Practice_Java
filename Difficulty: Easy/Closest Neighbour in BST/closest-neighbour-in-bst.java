/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */
class Solution {
    /**
     * Approach : Using DFS Approach
     * 
     * TC: O(log(N))
     * SC: O(log(N))
     */
    public int findMaxFork(Node root, int k) {
        int[] result = { -1 };
        dfsTree(root, k, result);
        return result[0];
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(log(N))
     * SC: O(log(N))
     */
    private void dfsTree(Node root, int k, int[] result) {
        // Base Case
        if (root == null) {
            return;
        }
        if (root.data <= k) {
            result[0] = root.data;
            dfsTree(root.right, k, result);
        } else if (root.data > k) {
            dfsTree(root.left, k, result);
        }
    }
}
