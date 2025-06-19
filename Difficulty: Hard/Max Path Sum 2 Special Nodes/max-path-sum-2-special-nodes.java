/* class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    /**
     * Approach : Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    int maxPathSum(Node root) {
        int[] maxSum = { Integer.MIN_VALUE };
        int value = solveRecursion(root, maxSum);
        if (root.left == null || root.right == null) {
            maxSum[0] = Math.max(maxSum[0], value);
        }
        return maxSum[0];
    }
    
    /**
     * Using Recursion Approach
     *
     * TC: O(N)
     * SC: O(N)
     */
    private int solveRecursion(Node node, int[] maxSum) {
        // Base Case
        if (node == null) {
            return 0;
        }
        // Hypothesis - Recursion Calls
        int leftSum = solveRecursion(node.left, maxSum);
        int rightSum = solveRecursion(node.right, maxSum);
        // Induction
        // if we consider the current node which is non-leaf node
        if (node.left != null && node.right != null) {
            // node is not a leaf node
            maxSum[0] = Math.max(maxSum[0], node.data + leftSum + rightSum);
            // return the maximum / best result to it's parent node
            return node.data + Math.max(leftSum, rightSum);
        }
        // if the node has only one child
        return node.data + (node.left == null ? rightSum : leftSum);
    }
}
