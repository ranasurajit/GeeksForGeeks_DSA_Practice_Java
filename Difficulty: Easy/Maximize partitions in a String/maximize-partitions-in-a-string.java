//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            int ans = obj.maxPartitions(s);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    /**
     * Approach : Using Two Pointers Approach
     * 
     * TC: O(2 x N) ~ O(N)
     * SC: O(26) ~ O(1)
     */
    public int maxPartitions(String s) {
        int n = s.length();
        // we need to pre-compute the last occurence indices of each character
        int[] lastOccur = new int[26]; // SC: O(26) ~ O(1)
        for (int i = 0; i < n; i++) { // TC: O(N)
            lastOccur[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        int i = 0;
        int countPartitions = 0;
        while (i < n) { // TC: O(N)
            end = Math.max(end, lastOccur[s.charAt(i) - 'a']);
            if (i == end) {
                countPartitions++;
                start = end + 1;
            }
            i++;
        }
        return countPartitions;
    }
}
