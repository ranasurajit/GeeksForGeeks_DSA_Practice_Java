//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    /**
     * TC: O(Nlog(M))
     * SC: O(1)
     */
    public int NthRoot(int n, int m) {
        if (n == 1) {
            return m;
        }
        if (m == 1) {
            return 1;
        }
        int low = 2;
        int high = m;
        while (low <= high) { // TC: O(log(M))
            int mid = low + (high - low) / 2;
            double prod = product(mid, n); // TC: O(N)
            if (prod == m) {
                return mid;
            } else if (prod < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    private double product(int num, int times) {
        double prod = 1;
        for (int i = 1; i <= times; i++) {
            prod *= num;
        }
        return prod;
    }
}
