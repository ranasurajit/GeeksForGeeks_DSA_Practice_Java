/* Structure of Doubly Linked List
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        next = prev = null;
    }
}*/

class Solution {
    // Function to insert a new node at given position in doubly linked list.
    /**
     * Approach : Using Linked-List Traversal Approach
     * 
     * TC: O(Min(N, P))
     * SC: O(1)
     */
    Node addNode(Node head, int p, int x) {
        Node current = head;
        int count = 0;
        while (current != null && count < p) { // TC: O(Min(N, P))
            current = current.next;
            count++;
        }
        // creating a new node
        Node newNode = new Node(x);
        // attach next pointer
        newNode.next = current.next;
        // attach previous pointer
        newNode.prev = current;
        current.next = newNode;
        return head;
    }
}
