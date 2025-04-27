//{ Driver Code Starts
// Initial Template for Java

import java.math.*;
import java.util.*;

class Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            Solution g = new Solution();
            System.out.println(g.multiplyStrings(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * Approach : Using String and Math Approach
     * 
     * TC: O((M x N)+ 2 x (M + N)) ~ O(M x N)
     * SC: O(M + N)
     */
    public String multiplyStrings(String s1, String s2) {
        boolean negative = false;
        // Checking for negative numbers
        if (s1.length() > 0 && s1.charAt(0) == '-') {
            negative = !negative;
            s1 = s1.substring(1);
        }
        if (s2.length() > 0 && s2.charAt(0) == '-') {
            negative = !negative;
            s2 = s2.substring(1);
        }
        s1 = removeLeadingZeros(s1); // TC: O(M)
        s2 = removeLeadingZeros(s2); // TC: O(N)
        if (s1.equals("0") || s2.equals("0")) {
            return "0";
        }
        int m = s1.length();
        int n = s2.length();
        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; i--) { // TC: O(M)
            for (int j = n - 1; j >= 0; j--) { // TC: O(N)
                int prod = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int sum = prod + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder(); // SC: O(M + N)
        for (int item : result) { // TC: O(M + N)
            if (!(sb.length() == 0 && item == 0)) {
                sb.append(item);
            }
        }
        if (negative) {
            sb.insert(0, '-');
        }
        return sb.toString();
    }
 
    /**
     * TC: O(N)
     * SC: O(1)
     */
    private String removeLeadingZeros(String s) {
        int index = 0;
        while (index < s.length() && s.charAt(index) == '0') {
            index++;
        }
        return index == s.length() ? "0" : s.substring(index);
    }
}
