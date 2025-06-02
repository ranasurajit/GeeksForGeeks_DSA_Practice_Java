// User function Template for Java

class Solution {
    /**
     * Approach : Using Sliding Window Approach (Variable Length)
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(N)
     */
    int countSubstr(String s, int k) {
        int n = s.length();
        return countSubstringLessThanK(s, n, k) - countSubstringLessThanK(s, n, k - 1);
    }
    
    /**
     * Using Sliding Window Approach (Variable Length)
     * 
     * TC: O(N)
     * SC: O(N)
     */
    private int countSubstringLessThanK(String s, int n, int k) {
        int i = 0;
        int j = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>(); // SC: O(N)
        int count = 0;
        while (j < n) { // TC: O(N)
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while (map.size() > k) {
                // remove computation from index 'i'
                int freq = map.get(s.charAt(i));
                if (freq == 1) {
                    map.remove(s.charAt(i));
                } else {
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                }
                i++;
            }
            if (map.size() <= k) {
                count += (j - i + 1);
            }
            j++;
        }
        return count;
    }
}
