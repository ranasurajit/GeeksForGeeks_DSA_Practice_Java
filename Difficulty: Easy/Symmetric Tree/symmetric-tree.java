/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class Solution {
    /**
     * Approach : Using DFS Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return isTreeMirror(root.left, root.right);
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    private boolean isTreeMirror(Node leftRoot, Node rightRoot) {
        if (leftRoot == null) {
            return rightRoot == null;
        }
        if (rightRoot == null) {
            return leftRoot == null;
        }
        return leftRoot.data == rightRoot.data &&
            isTreeMirror(leftRoot.left, rightRoot.right) &&
            isTreeMirror(leftRoot.right, rightRoot.left);
    }
}
