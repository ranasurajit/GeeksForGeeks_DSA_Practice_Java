class Solution {
    /**
     * Approach : Using Recursion Approach
     * 
     * TC: O(N ^ 3)
     * SC: O(N)
     */
    public boolean isSumString(String s) {
        int n = s.length();
        for (int len1 = 1; len1 < n; len1++) { // TC: O(N)
            for (int len2 = 1; len1 + len2 < n; len2++) { // TC: O(N)
                if (checkSequences(s, 0, n, len1, len2)) { // TC: O(N)
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    private boolean checkSequences(String s, int start, int n, int len1, int len2) {
        String num1 = s.substring(start, start + len1);
        String num2 = s.substring(start + len1, start + len1 + len2);
        String sum = addTwoStrings(num1, num2); // TC: O(Max(N1, N2)), SC: O(Max(N1, N2))
        int size = sum.length();
        if (start + len1 + len2 + size > n) {
            return false;
        }
        if (sum.equals(s.substring(start + len1 + len2, start + len1 + len2 + size))) {
            if (start + len1 + len2 + size == n) {
                return true;
            }
            return checkSequences(s, start + len1, n, len2, size);
        }
        return false;
    }
    
    /**
     * Using Two Pointers Approach
     * 
     * TC: O(Max(Len(Num1, Num2))) ~ O(Max(N1, N2))
     * SC: O(Max(N1, N2))
     */
    private String addTwoStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder(); // SC: O(Max(N1, N2))
        int n1 = num1.length();
        int n2 = num2.length();
        int p = n1 - 1;
        int q = n2 - 1;
        int carry = 0;
        while (p >= 0 || q >= 0 || carry != 0) {
            int v1 = p >= 0 ? num1.charAt(p) - '0' : 0;
            int v2 = q >= 0 ? num2.charAt(q) - '0' : 0;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            sb.insert(0, sum % 10);
            p--;
            q--;
        }
        return sb.toString();
    }
}
