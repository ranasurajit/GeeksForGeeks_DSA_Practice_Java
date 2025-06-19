class Solution {
    /**
     * Approach : Using StringBuilder + Sorting Approach
     * 
     * TC: O(2 x N + K x log(K) + (N - K) x log(N - K)) ~ O(N x log(N))
     * SC: O(4 x N) ~ O(N)
     * 
     * where K = number of Capital Characters in String 's'
     */
    public static String caseSort(String s) {
        int n = s.length();
        StringBuilder sbCaps = new StringBuilder();  // SC: O(N)
        StringBuilder sbSmall = new StringBuilder(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = s.charAt(i);
            if (Character.isUpperCase(ch)) {
                sbCaps.append(ch);
            } else {
                sbSmall.append(ch);
            }
        }
        char[] chCaps = String.valueOf(sbCaps).toCharArray();   // SC: O(N)
        char[] chSmall = String.valueOf(sbSmall).toCharArray(); // SC: O(N)
        Arrays.sort(chCaps);  // TC: O(K x log(K)), where K = number of Capital Characters in String 's'
        Arrays.sort(chSmall); // TC: O((N - K) x log(N - K))
        // Using Two Pointers Approach
        sbCaps = null;
        sbSmall = new StringBuilder();
        int p = 0; // starting pointer at chCaps
        int q = 0; // starting pointer at chSmall
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = s.charAt(i);
            if (Character.isUpperCase(ch)) {
                sbSmall.append(chCaps[p]);
                p++;
            } else {
                sbSmall.append(chSmall[q]);
                q++;
            }
        }
        return String.valueOf(sbSmall);
    }
}
