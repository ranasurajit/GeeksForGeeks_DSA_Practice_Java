// User function Template for Java

class Solution {
    /**
     * Approach : Using Recursion + BST Property Approach
     * 
     * TC: O(H)
     * SC: O(H)
     * 
     * where H = height of BST
     * H = log(N) for balanced BST
     * H = N for skewed Tree
     */
    public static int floor(Node root, int x) {
        if (root == null) {
            return -1;
        }
        int[] floorVal = { Integer.MIN_VALUE };
        solveRecursion(root, x, floorVal);
        return floorVal[0] == Integer.MIN_VALUE ? -1 : floorVal[0];
    }
    
    /**
     * Using Recursion + BST Property Approach
     * 
     * TC: O(H)
     * SC: O(H)
     */
    private static void solveRecursion(Node root, int x, int[] floorVal) {
        // Base Case
        if (root == null) {
            return;
        }
        // Recursion Calls
        if (x < root.data) {
            // we need to lookup to the left of root node
            solveRecursion(root.left, x, floorVal);
        } else {
            // we need to lookup to the right of root node
            floorVal[0] = Math.max(floorVal[0], root.data);
            solveRecursion(root.right, x, floorVal);
        }
    }
}
