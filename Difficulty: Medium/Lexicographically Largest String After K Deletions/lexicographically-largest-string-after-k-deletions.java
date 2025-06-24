class Solution {
    /**
     * Approach : Using StringBuilder Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public static String maxSubseq(String s, int k) {
        int n = s.length();
        int remaining = k;
        StringBuilder sb = new StringBuilder(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) < s.charAt(i) 
                && remaining > 0) {
                sb.deleteCharAt(sb.length() - 1);
                remaining--;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString().substring(0, n - k);
    }
}
