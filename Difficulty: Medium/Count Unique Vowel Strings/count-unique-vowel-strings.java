class Solution {
    /**
     * Approach : Using Hashing + Math Approach
     * 
     * TC: O(N) + O(N) ~ O(N)
     * SC: O(5) ~ O(1)
     */
    public int vowelCount(String s) {
        int n = s.length();
        Set<Character> vowels = 
            new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u')); // SC: O(5)
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) { // TC: O(N)
            if (vowels.contains(s.charAt(i))) {
                freq[s.charAt(i) - 'a']++;
            }
        }
        int totalCount = 1;
        int countVowels = 0;
        for (char ch : vowels) { // TC: O(5)
            int freqChar = freq[ch - 'a']++;
            if (freqChar > 0) {
                countVowels++;
                totalCount = totalCount * freqChar; // counting for each vowel occurences
            }
        }
        totalCount = totalCount * factorial(countVowels); // TC: O(N), SC: O(1)
        return totalCount;
    }
    
    /**
     * Using Iterative Approach
     * 
     * TC: O(N)
     * SC: O(1)
     */
    private int factorial(int n) {
        if (n <= 1) {
            return n;
        }
        int fact = 1;
        for (int i = n; i >= 1; i--) { // TC: O(1)
            fact = fact * i;
        }
        return fact;
    }
}
