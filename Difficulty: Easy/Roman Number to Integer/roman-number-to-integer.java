class Solution {
    private static final String[] mappings = 
        { "I1", "V5", "X10", "L50", "C100", "D500", "M1000" };

    /**
     * Approach : Using Hashing + Stack Approach
     * 
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(N)
     */
    public int romanToDecimal(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // SC: O(7) ~ O(1)
        for (String m : mappings) {   // TC: O(7) ~ O(1)
            map.put(m.charAt(0), Integer.valueOf(m.substring(1, m.length())));
        }
        int n = s.length();
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            st.push(s.charAt(i));
        }
        int last = map.get(st.pop());
        int sum = last;
        while (!st.isEmpty()) {       // TC: O(N)
            int current = map.get(st.pop());
            if (current < last) {
                sum -= current;
            } else {
                sum += current;
            }
            last = current;
        }
        return sum;
    }
}
