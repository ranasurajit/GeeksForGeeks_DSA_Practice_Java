/*Complete the function below
Node is as follows:
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

*/
class Solution {
    // Function to check whether all nodes of a tree have the value
    // equal to the sum of their child nodes.
    /**
     * Approach : Using Recursion Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public static int isSumProperty(Node root) {
        return hasChildrenSum(root) ? 1 : 0;
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    private static boolean hasChildrenSum(Node root) {
        // Base Case
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        int leftVal = root.left == null ? 0 : root.left.data;
        int rightVal = root.right == null ? 0 : root.right.data;
        return leftVal + rightVal == root.data &&
            hasChildrenSum(root.left) && hasChildrenSum(root.right);
    }
}
