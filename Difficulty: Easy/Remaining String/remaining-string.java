//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            char ch = sc.next().charAt(0);
            int count = sc.nextInt();
            Solution ob = new Solution();
            String result = ob.printString(s, ch, count);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


class Solution {
    public String printString(String s, char ch, int count) {
        int counter = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                counter++;
                if (counter == count) {
                    index = i;
                    break;
                }
            }
        }
        if (counter < count) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index + 1; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
