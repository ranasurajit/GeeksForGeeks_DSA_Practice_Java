class Solution {
    /**
     * Approach : Using Stack Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public int findLength(int[] color, int[] radius) {
        int n = color.length;
        Stack<int[]> st = new Stack<int[]>(); // TC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            while (!st.isEmpty() && st.peek()[0] == color[i] && st.peek()[1] == radius[i]) {
                st.pop();
                color[i] = 0;
                radius[i] = 0;
            }
            if (color[i] != 0 && radius[i] != 0) {
                st.push(new int[] { color[i], radius[i] });
            }
        }
        return st.size();
    }
}
