class Solution {
    /**
     * Approach : Using Sliding Window (Fixed Size) Approach
     * 
     * TC: O(N)
     * SC: O(26)
     */
    public int substrCount(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = 0;
        Map<Character, Integer> freqMap = new HashMap<Character, Integer>(); // SC: O(26)
        int count = 0;
        while (j < n) { // TC: O(N)
            char ch = s.charAt(j);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                if (freqMap.size() == k - 1) {
                    count++;
                }
                // remove calculation from index 'i'
                char current = s.charAt(i);
                freqMap.put(current, freqMap.get(current) - 1);
                if (freqMap.get(current) == 0) {
                    freqMap.remove(current);
                }
                // slide to next window of size k
                i++;
                j++;
            }
        }
        return count;
    }
}
