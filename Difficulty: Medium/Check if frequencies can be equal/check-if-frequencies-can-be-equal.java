class Solution {
    /**
     * Approach : Using Hashing Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    boolean sameFreq(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) { // TC: O(N)
            freq[s.charAt(i) - 'a']++;
        }
        HashMap<Integer, Integer> countMap =
            new HashMap<Integer, Integer>(); // SC: O(2) ~ O(1)
        for (int i = 0; i < 26; i++) { // TC: O(26)
            if (freq[i] > 0) {
                countMap.put(freq[i], countMap.getOrDefault(freq[i], 0) + 1);
            }
        }
        if (countMap.size() > 2) {
            return false;
        } else if (countMap.size() == 1) {
            return true;
        }
        // here countMap.size() = 2
        List<Integer> frequencies = new ArrayList<Integer>(countMap.keySet());
        int f1 = frequencies.get(0);
        int f2 = frequencies.get(1);
        int c1 = countMap.get(f1);
        int c2 = countMap.get(f2);
        // if any frequency and its count are both 1 and all others > 1 then we can remove the former
        if ((c1 == 1 && f1 == 1) || (c2 == 1 && f2 == 1)) {
            // consider case when s = "bbadd" which would return true
            return true;
        }
        if (Math.abs(f1 - f2) == 1) { 
            /**
             * consider case when s = "bbbaaddd" which would return false and
             * case when "bbbaaaaddd" would return true
             */
            if ((c1 == 1 && f1 > f2) || (c2 == 1 && f2 > f1)) {
                return true;
            }
        }
        return false;
    }
}
