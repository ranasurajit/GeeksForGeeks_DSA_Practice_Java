/*
class DLLNode {
    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int val) {
        data = val;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    /**
     * Approach : Using Two Pointers Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public DLLNode reverseDLL(DLLNode head) {
        DLLNode prev = null;
        DLLNode current = head;
        while (current != null) { // TC: O(N)
            DLLNode temp = current.next;
            current.next = prev;
            prev = current;
            prev.prev = current;
            current = temp;
        }
        return prev;
    }
}
