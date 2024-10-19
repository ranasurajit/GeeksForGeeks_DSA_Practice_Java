//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String str, int k) {
        int len = str.length();
        int[] alphabets = new int[26];
        int numChars = 0;
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                alphabets[str.charAt(i) - 'a'] = 1;
                numChars++;
            }
        }
        int empty = 0;
        for (int i = 0; i < 26; i++) {
            if (alphabets[i] == 0) {
                empty++;
            }
        }
        if (numChars < 26 || empty > k) {
            return false;
        }
        return true;
    }
}
