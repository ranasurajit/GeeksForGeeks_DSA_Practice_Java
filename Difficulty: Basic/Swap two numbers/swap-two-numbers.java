class Solution {
    /**
     * Approach : Using Bit-Manipulation Approach
     * 
     * TC: O(1)
     * SC: O(1)
     */
    static List<Integer> get(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        List<Integer> result = new ArrayList<Integer>();
        result.add(a);
        result.add(b);
        return result;
    }
}
