class Solution {
    /**
     * Approach II : Using Optimal Approach
     * 
     * TC: O(N)
     * SC: O(1)
     * 
     * Accepted (Test Cases Passed: 1125 / 1125)
     */
    int countStrings(String s) {
        int n = s.length();
        int[] freq = new int[26]; // SC: O(26) ~ O(1)
        for (int i = 0; i < n; i++) { // TC: O(N)
            freq[s.charAt(i) - 'a']++;
        }
        // ith character can form pairs with (i + 1), (i + 2)... (n - 1)
        // all pairs count = (n - 1) + (n - 2) + ... 1 = ((n - 1) * n) / 2
        int result = (n * (n - 1)) / 2;
        boolean hasDuplicates = false;
        for (int i = 0; i < 26; i++) { // TC: O(26) ~ O(1)
            if (freq[i] > 1) {
                hasDuplicates = true;
                // duplicate pairs we need to remove = ((numDup - 1) * numDup) / 2
                result = result - (freq[i] * (freq[i] - 1)) / 2;
            }
        }
        return hasDuplicates ? result + 1 : result;
    }

    /**
     * Approach I : Using Brute-Force Approach
     * 
     * TC: O(N x N)
     * SC: O(N)
     * 
     * Memory Limit Exceeded (Test Cases Passed: 1010 / 1125)
     */
    int countStringsBruteForce(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Set<String> hs = new HashSet<String>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = i + 1; j < n; j++) { // TC: O(N)
                swapChars(chars, i, j);
                hs.add(String.valueOf(chars));
                swapChars(chars, i, j); // backtrack
            }
        }
        return hs.size();
    }

    /**
     * TC: O(1)
     * SC: O(1)
     */
    private void swapChars(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}
