/*

Definition for doubly Link List Node
class Node {
    int data;
    Node next;
    Node prev;

    Node(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    /**
     * Approach : Using Linked-List Traversal Approach
     * 
     * TC: O(Min(N, X))
     * SC: O(1)
     */
    public Node deleteNode(Node head, int x) {
        if (head == null) {
            return null;
        }
        if (x == 1) {
            Node newHead = head.next;
            if (newHead != null) {
                newHead.prev = null;
            }
            return newHead;
        }
        int count = 1;
        Node prev = null;
        Node current = head;
        while (current != null && count < x) { // TC: O(Min(N, X))
            prev = current;
            current = current.next;
            count++;
        }
        prev.next = current != null ? current.next : null;
        if (current != null && current.next != null) {
            current.next.prev = prev;
        }
        return head;
    }
}
