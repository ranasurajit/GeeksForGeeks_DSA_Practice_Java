class Solution {
    /**
     * Approach : Using Two Pointers Approach
     * 
     * TC: O(N) + O(N / 2) ~ O(N)
     * SC: O(N)
     */
    public boolean isPalinSent(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                ch = Character.toLowerCase(ch);
                sb.append(ch);
            }
        }
        // we have the filtered String without spaces or non-alphanumeric characters
        // now we can perform Palindrome Check using Two Pointers Approach
        int p = 0;
        int q = sb.length() - 1;
        while (p < q) { // TC: O(N / 2)
            if (sb.charAt(p) != sb.charAt(q)) {
                return false;
            }
            p++;
            q--;
        }
        return true;
    }
}
