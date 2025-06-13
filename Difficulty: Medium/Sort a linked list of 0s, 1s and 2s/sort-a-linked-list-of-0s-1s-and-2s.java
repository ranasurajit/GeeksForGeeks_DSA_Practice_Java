/* class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}*/
class Solution {
    /**
     * Approach : Using Two Pointers Approach
     *
     * TC: O(N)
     * SC: O(1)
     */
    static Node segregate(Node head) {
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node curr0 = zeroHead;
        Node curr1 = oneHead;
        Node curr2 = twoHead;
        int zeroLength = 0;
        int oneLength = 0;
        int twoLength = 0;
        Node current = head;
        while (current != null) { // TC: O(N)
            if (current.data == 0) {
                curr0.next = current;
                curr0 = curr0.next;
                zeroLength++;
            } else if (current.data == 1) {
                curr1.next = current;
                curr1 = curr1.next;
                oneLength++;
            } else {
                curr2.next = current;
                curr2 = curr2.next;
                twoLength++;
            }
            current = current.next;
        }
        curr2.next = null;
        if (zeroLength > 0) {
            curr0.next = oneLength > 0 ? oneHead.next : twoHead.next;
            curr1.next = twoLength > 0 ? twoHead.next : null;
            return zeroHead.next;
        } else {
            if (oneLength > 0) {
                curr1.next = twoLength > 0 ? twoHead.next : null;
                return oneHead.next;
            } else {
                return twoHead.next;
            }
        }
    }
}
