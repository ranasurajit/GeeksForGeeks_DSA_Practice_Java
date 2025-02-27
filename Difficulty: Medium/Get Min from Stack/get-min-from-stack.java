//{ Driver Code Starts
import java.util.*;

class Get_Min_From_Stack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases

        while (T-- > 0) {
            int q = sc.nextInt(); // Number of queries
            Solution g = new Solution();

            while (q-- > 0) {
                int qt = sc.nextInt();

                if (qt == 1) {
                    int att = sc.nextInt();
                    g.push(att);
                } else if (qt == 2) {
                    g.pop(); // Just call pop(), do not print anything
                } else if (qt == 3) {
                    System.out.print(g.peek() + " "); // Print top element
                } else if (qt == 4) {
                    System.out.print(g.getMin() + " "); // Print minimum element
                }
            }
            System.out.println("\n~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {

    private Stack<Integer> st;
    private int minValue;
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public Solution() {
        st = new Stack<Integer>();
        minValue = Integer.MAX_VALUE;
    }

    // Add an element to the top of Stack
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public void push(int x) {
        if (st.isEmpty()) {
            minValue = x;
        } else {
            if (x < minValue) {
                st.push(minValue);
                minValue = x;
            }
        }
        st.push(x);
    }

    // Remove the top element from the Stack
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public void pop() {
        if (st.isEmpty()) {
            return;
        }
        int peek = st.peek();
        st.pop();
        if (peek == minValue && !st.isEmpty()) {
            minValue = st.pop();
        }
    }

    // Returns top element of the Stack
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public int peek() {
        return st.isEmpty() ? -1 : st.peek();
    }

    // Finds minimum element of Stack
    /**
     * TC: O(1)
     * SC: O(1)
     */
    public int getMin() {
        return st.isEmpty() ? -1 : minValue;
    }
}
