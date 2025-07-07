class Solution {
    /**
     * Approach : Using Monotonic Stack Approach
     * 
     * TC: O(3 x N) ~ O(N)
     * SC: O(2 x N) ~ O(N)
     */
    public ArrayList<Integer> findGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>(); // SC: O(N)
        for (int elem : arr) { // TC: O(N)
            freqMap.put(elem, freqMap.getOrDefault(elem, 0) + 1);
        }
        int[] nge = new int[n]; // SC: O(N)
        Stack<int[]> st = new Stack<int[]>(); // SC: O(N)
        for (int i = n - 1; i >= 0; i--) { // TC: O(N)
            while (!st.isEmpty() && freqMap.get(arr[i]) >= st.peek()[2]) {
                st.pop();
            }
            int value = st.isEmpty() ? -1 : st.peek()[1];
            nge[i] = value;
            st.push(new int[] { value, arr[i], freqMap.get(arr[i]) });
        }
        for (int i = 0; i < n; i++) { // TC: O(N)
            result.add(nge[i]);
        }
        return result;
    }
}
