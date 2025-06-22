/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/
class Solution {
    // Function to find the minimum element in the given BST.
    /**
     * Approach : Using Property of Binary Search Tree
     * 
     * TC: O(log(N))
     * SC: O(log(N))
     */
    int minValue(Node root) {
        if (root == null) {
            return -1;
        }
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }
}
