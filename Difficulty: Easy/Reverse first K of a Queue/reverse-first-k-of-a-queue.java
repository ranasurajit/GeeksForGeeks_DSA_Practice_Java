class Solution {
    /**
     * Approach : Using Queue Approach
     * 
     * TC: O(N + K)
     * SC: O(K)
     */
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        if (q.size() < k) {
            return q;
        }
        int count = q.size() - k;
        Stack<Integer> st = new Stack<Integer>(); // SC: O(K)
        while (k > 0) { // TC: O(K)
            st.push(q.poll());
            k--;
        }
        while (!st.isEmpty()) { // TC: O(K)
            q.offer(st.pop());
        }
        while (count > 0) { // TC: O(N - K)
            q.offer(q.poll());
            count--;
        }
        return q;
    }
}
