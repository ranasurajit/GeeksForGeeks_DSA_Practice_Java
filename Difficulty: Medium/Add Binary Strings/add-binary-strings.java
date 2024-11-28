//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
     * TC: O(Max(N1, N2))
     * SC: O(Max(N1, N2))
     */
    public String addBinary(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int p = n1 - 1; // pointer for String 's1'
        int q = n2 - 1; // pointer for String 's2'
        int carry = 0;
        StringBuilder sb = new StringBuilder(); // SC: O(Max(N1, N2))
        while (p >= 0 || q >= 0) { // TC: O(Max(N1, N2))
            int digit1 = p >= 0 ? s1.charAt(p) - '0' : 0;
            int digit2 = q >= 0 ? s2.charAt(q) - '0' : 0;
            int total = digit1 + digit2 + carry;
            if (total == 0) {
                sb.append('0');
                carry = 0;
            } else if (total == 1) {
                sb.append('1');
                carry = 0;
            } else if (total == 2) {
                sb.append('0');
                carry = 1;
            } else if (total == 3) {
                sb.append('1');
                carry = 1;
            }
            p--;
            q--;
        }
        if (carry == 1) {
            sb.append('1');
        }
        while (sb.charAt(sb.length() - 1) == '0') {
            sb.setLength(sb.length() - 1);
        }
        return sb.reverse().toString();
    }
}
