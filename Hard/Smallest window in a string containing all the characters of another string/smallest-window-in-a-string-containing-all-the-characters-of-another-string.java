//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    /**
     * TC: O(M + N) ~ O(|s|)
     * SC: O(52) ~ O(1)
     */
    public static String smallestWindow(String s, String p) {
        int n = s.length();
        int m = p.length();
        if (m > n) {
            return "-1";
        }
        int[] pHash = new int[26]; // SC: O(26)
        int[] sHash = new int[26]; // SC: O(26)
        int countP = 0;
        int countS = 0;
        for (int i = 0; i < m; i++) { // TC: O(M)
            char x = p.charAt(i);
            pHash[x - 'a']++;
            if (pHash[x - 'a'] == 1) {
                countP++;
            }
        }
        int j = 0;
        int start = -1;
        int end = -1;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) { // TC: O(N)
            char x = s.charAt(i);
            sHash[x - 'a']++;
            if (sHash[x - 'a'] == pHash[x - 'a']) {
                countS++;
            }
            if (countS == countP) {
                while (sHash[s.charAt(j) - 'a'] > pHash[s.charAt(j) - 'a']) {
                    sHash[s.charAt(j) - 'a']--;
                    j++; // shrinking size when count matches
                }
                if (minLength > i - j + 1) {
                    minLength = i - j + 1;
                    start = j;
                    end = i;
                }
            }
        }
        if (start == -1) {
            return "-1";
        }
        return s.substring(start, end + 1);
    }
}
