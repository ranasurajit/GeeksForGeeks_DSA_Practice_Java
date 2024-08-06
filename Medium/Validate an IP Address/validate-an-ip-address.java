//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean isValid(String str) {
        int chPos = 0;
        int dotPos = 0;
        int index = 0;
        int segments = 0;
        while (index < str.length()) {
            while (index < str.length() && str.charAt(index) != '.') {
                dotPos++;
                index++;
            }
            if (dotPos - chPos <= 0) {
                // if two dots are next to each other
                return false;
            }
            String segment = str.substring(chPos, dotPos);
            if (segment.length() > 1 && segment.charAt(0) == '0') {
                // if the segment number has a leading zero
                return false;
            }
            int value = Integer.valueOf(segment);
            if (value < 0 || value > 255) {
                // valid segment in ip-address is >=0 && <= 255
                return false;
            }
            dotPos++;
            chPos = dotPos;
            index = dotPos;
            segments++;
        }
        if (segments != 4) {
            // number of valid segments in ip-address = 4
            return false;
        }
        return true;
    }
}
