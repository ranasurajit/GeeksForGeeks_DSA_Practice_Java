//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();//testcases
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int n,k;
		    //taking input n and k
		    n=sc.nextInt();
		    k=sc.nextInt();
		    
		    //calling josephus() function
		    System.out.println(obj.josephus(n,k));
		    
		    
		
System.out.println("~");
}
		
	}
}


// } Driver Code Ends


class Solution {
    /**
     * Approach : Using Recursion Approach
     * 
     * TC: O(N ^ 2 + N) ~ O(N ^ 2)
     * SC: O(2 x N) ~ O(N)
     */
    public int josephus(int n, int k) {
        List<Integer> persons = new ArrayList<Integer>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            persons.add(i + 1);
        }
        k = k - 1; // 0 based indexing
        solveRecursion(0, persons, k); // TC: O(N ^ 2), SC: O(N)
        return persons.get(0);
    }
    
    /**
     * TC: O(N ^ 2)
     * SC: O(N)
     */
    private static void solveRecursion(int startIndex, List<Integer> persons, int k) {
        // Base Case
        if (persons.size() == 1) {
            return;
        }
        // Hypothesis
        /**
         * We assume that if we eliminate the kth person from startIndex, then recussion
         * will handle eliminating other persons with kth offset from startIndex
         */
        int killIndex = (startIndex + k) % persons.size();
        persons.remove(killIndex); // TC: O(N)
        // now the next person to start the count will be from killIndex
        solveRecursion(killIndex, persons, k);
        // Induction - Not required
    }
}
