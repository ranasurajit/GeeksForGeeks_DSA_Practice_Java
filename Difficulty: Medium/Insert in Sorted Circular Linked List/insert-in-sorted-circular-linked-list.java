/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
} */

class Solution {
    /**
     * Approach : Using Two Pointers Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    public Node sortedInsert(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }
        Node newNode = new Node(data);
        if (head.next == null) {
            Node newHead = null;
            if (head.data <= data) {
                head.next = newNode;
                newNode.next = head;
                newHead = head;
            } else {
                head.next = null;
                newNode.next = head;
                head.next = newNode;
                newHead = newNode;
            }
            return newHead;
        }
        Node current = head;
        Node nextNode = head.next;
        if (head.data > data) {
            newNode.next = head;
            while (nextNode != head) {
                nextNode = nextNode.next;
                current = current.next;
            }
            current.next = newNode;
            return newNode;
        }
        current = head;
        nextNode = head.next;
        while (nextNode != null && nextNode.data <= data) { // TC: O(N)
            nextNode = nextNode.next;
            current = current.next;
            if (nextNode == head) {
                break;
            }
        }
        // at this point nextNode value > data
        current.next = newNode;
        newNode.next = nextNode;
        return head;
    }
}
