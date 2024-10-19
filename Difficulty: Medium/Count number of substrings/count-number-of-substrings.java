//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    /**
     * TC: O(N)
     * SC: O(N)
     */
    long substrCount (String S, int K) {
        return count(S, K) - count(S, K - 1);
    }
    
    private long count(String S, int K) {
        int n = S.length();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>(); // SC: O(N)
        long count = 0L;
        for (int i = 0, j = 0; j < n; j++) { // TC: O(N)
            hm.put(S.charAt(j), hm.getOrDefault(S.charAt(j), 0) + 1);
            while (hm.size() > K) {
                int size = hm.get(S.charAt(i));
                hm.put(S.charAt(i), size - 1);
                if (size - 1 == 0) {
                    hm.remove(S.charAt(i));
                }
                i++;
            }
            count += j - i + 1;
        }
        return count;
    } 
}
