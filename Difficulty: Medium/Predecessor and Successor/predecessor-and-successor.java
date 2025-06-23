/* BST Node
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
     * Approach : Using Property of BST Approach
     * 
     * TC: O(2 x H) ~ O(H)
     * SC: O(2 x H) ~ O(H)
     */
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> result = new ArrayList<Node>();
        Node predecessor = findPredecessor(root, key); // TC: O(H), SC: O(H)
        Node successor = findSuccessor(root, key);     // TC: O(H), SC: O(H)
        if (predecessor == null || predecessor.data >= key) {
            result.add(new Node(-1));
        } else {
            result.add(predecessor);
        }
        if (successor == null || successor.data <= key) {
            result.add(new Node(-1));
        } else {
            result.add(successor);
        }
        return result;
    }
    
    /**
     * Using Property of BST Approach
     * 
     * TC: O(H)
     * SC: O(H)
     */
    private Node findPredecessor(Node root, int key) {
        Node predecessor = null;
        while (root != null) {
            if (key <= root.data) {
                root = root.left;
            } else {
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }
    
    /**
     * Using Property of BST Approach
     * 
     * TC: O(H)
     * SC: O(H)
     */
    private Node findSuccessor(Node root, int key) {
        Node successor = root;
        while (root != null) {
            if (key < root.data) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }
}
