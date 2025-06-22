/* class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Tree {
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
    int findCeil(Node root, int key) {
        if (root == null) {
            return -1;
        }
        int[] ceilVal = { Integer.MAX_VALUE };
        solveRecursion(root, key, ceilVal); // TC: O(H), SC: O(H)
        return ceilVal[0] == Integer.MAX_VALUE ? -1 : ceilVal[0];
    }
    
    /**
     * Using Recursion + BST Property Approach
     * 
     * TC: O(H)
     * SC: O(H)
     */
    private void solveRecursion(Node root, int key, int[] ceilVal) {
        // Base Case
        if (root == null) {
            return;
        }
        // Recursion Calls
        if (key <= root.data) {
            ceilVal[0] = Math.min(ceilVal[0], root.data);
            solveRecursion(root.left, key, ceilVal);
        } else {
            solveRecursion(root.right, key, ceilVal);
        }
    }
}
