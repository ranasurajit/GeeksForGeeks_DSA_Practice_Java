class Solution {
    /**
     * Approach II : Using Memoization Approach
     * 
     * TC: O(N1 x N2 x N3)
     * SC: O(N1 x N2 x N3 + (N1 + N2 + N3))
     */
    int lcsOf3(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        int[][][] memo = new int[n1 + 1][n2 + 1][n3 + 1]; // SC: O(N1 x N2 x N3)
        for (int[][] mem : memo) {
            for (int[] m : mem) {
                Arrays.fill(m, -1);
            }
        }
        return lcsMemoization(s1, s2, s3, n1, n2, n3, memo);
    }
    
    /**
     * Using Memoization Approach
     * 
     * TC: O(N1 x N2 x N3)
     * SC: O(N1 + N2 + N3)
     */
    private int lcsMemoization(String s1, String s2, String s3,
        int n1, int n2, int n3, int[][][] memo) {
        // Base Case
        if (n1 == 0 || n2 == 0 || n3 == 0) {
            return 0;
        }
        // Memoization Check
        if (memo[n1][n2][n3] != -1) {
            return memo[n1][n2][n3];
        }
        // Recursion Calls
        int option2 = 0;
        int option3 = 0;
        int option4 = 0;
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1) && 
            s2.charAt(n2 - 1) == s3.charAt(n3 - 1)) {
            // we can choose to pick or not pick
            return memo[n1][n2][n3] = 
                1 + lcsMemoization(s1, s2, s3, n1 - 1, n2 - 1, n3 - 1, memo);
        } else if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1) &&
            s2.charAt(n2 - 1) != s3.charAt(n3 - 1)) {
            option2 = lcsMemoization(s1, s2, s3, n1 - 1, n2 - 1, n3, memo);
            option3 = lcsMemoization(s1, s2, s3, n1, n2, n3 - 1, memo);
        } else if (s1.charAt(n1 - 1) != s2.charAt(n2 - 1) &&
            s2.charAt(n2 - 1) == s3.charAt(n3 - 1)) {
            option2 = lcsMemoization(s1, s2, s3, n1, n2 - 1, n3 - 1, memo);
            option3 = lcsMemoization(s1, s2, s3, n1 - 1, n2, n3, memo);
        } else if (s1.charAt(n1 - 1) != s2.charAt(n2 - 1) &&
            s2.charAt(n2 - 1) != s3.charAt(n3 - 1)) {
            option2 = lcsMemoization(s1, s2, s3, n1 - 1, n2, n3, memo);
            option3 = lcsMemoization(s1, s2, s3, n1, n2 - 1, n3, memo);
            option4 = lcsMemoization(s1, s2, s3, n1, n2, n3 - 1, memo);
        }
        return memo[n1][n2][n3] = Math.max(option2, Math.max(option3, option4));
    }

    /**
     * Approach I : Using Recursion Approach
     * 
     * TC: O(2 ^ (N1 + N2 + N3))
     * SC: O(N1 + N2 + N3)
     */
    int lcsOf3Recursion(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        return lcsRecursion(s1, s2, s3, n1, n2, n3);
    }
    
    /**
     * Using Recursion Approach
     * 
     * TC: O(2 ^ (N1 + N2 + N3))
     * SC: O(N1 + N2 + N3)
     */
    private int lcsRecursion(String s1, String s2, String s3, int n1, int n2, int n3) {
        // Base Case
        if (n1 == 0 || n2 == 0 || n3 == 0) {
            return 0;
        }
        // Recursion Calls
        int option1 = 0;
        int option2 = 0;
        int option3 = 0;
        int option4 = 0;
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1) && s2.charAt(n2 - 1) == s3.charAt(n3 - 1)) {
            // we can choose to pick or not pick
            return 1 + lcsRecursion(s1, s2, s3, n1 - 1, n2 - 1, n3 - 1);
        } else if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1) &&
            s2.charAt(n2 - 1) != s3.charAt(n3 - 1)) {
            option2 = lcsRecursion(s1, s2, s3, n1 - 1, n2 - 1, n3);
            option3 = lcsRecursion(s1, s2, s3, n1, n2, n3 - 1);
        } else if (s1.charAt(n1 - 1) != s2.charAt(n2 - 1) &&
            s2.charAt(n2 - 1) == s3.charAt(n3 - 1)) {
            option2 = lcsRecursion(s1, s2, s3, n1, n2 - 1, n3 - 1);
            option3 = lcsRecursion(s1, s2, s3, n1 - 1, n2, n3);
        } else if (s1.charAt(n1 - 1) != s2.charAt(n2 - 1) &&
            s2.charAt(n2 - 1) != s3.charAt(n3 - 1)) {
            option2 = lcsRecursion(s1, s2, s3, n1 - 1, n2, n3);
            option3 = lcsRecursion(s1, s2, s3, n1, n2 - 1, n3);
            option4 = lcsRecursion(s1, s2, s3, n1, n2, n3 - 1);
        }
        return Math.max(option2, Math.max(option3, option4));
    }
}
