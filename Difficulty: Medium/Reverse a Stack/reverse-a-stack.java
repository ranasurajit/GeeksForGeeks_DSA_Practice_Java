//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        PrintWriter out=new PrintWriter(System.out);
        
        //taking testcases
        int t = Integer.parseInt(br.readLine()); 
    	for(int i=0;i<t;i++)
    	{
            String str=br.readLine();
    		
    		//input n and d
    	    int n=Integer.parseInt(str);
    		Stack<Integer> stack=new Stack<>();
    		String str1=br.readLine();
    		String[] starr1=str1.split(" ");
    		//inserting elements in the array
    		for(int j=0;j<n;j++)
    		{
    		    stack.push(Integer.parseInt(starr1[j]));
    		}
    		//calling reverse() function
            Solution.reverse(stack);
            for(int j:stack){
                out.print(j+" ");
            }
            out.println();
         
out.println("~");
}
         out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    /**
	 * Approach : Using Recursion Approach
	 *
	 * TC: O(N ^ 2)
	 * SC: O(N)
	 */
    static void reverse(Stack<Integer> s) {
        solveRecursion(s, s.size());
    }
    
    /**
	 * TC: O(N ^ 2)
	 * SC: O(N)
	 */
	private static void solveRecursion(Stack<Integer> s, int n) {
		// Base Case
		if (n == 1) {
			// it is reversed already
			return;
		}
		// Hypothesis - we assume that recursion method will already deduce reverse of stack of size [0, (n - 1)]
		int lastValue = s.pop(); // Stack size is reduced
		solveRecursion(s, n - 1); // we get a reversed Stack here
		// Induction
		insertInReversedStack(s, lastValue); // TC: O(N)
	}

	/**
	 * TC: O(N)
	 * SC: O(N)
	 */
	private static void insertInReversedStack(Stack<Integer> s, int element) {
		// Base Case
		if (s.isEmpty()) {
			s.push(element);
			return;
		}
		// Hypothesis - we assume that recursion will insert element with Stack size (size - 1)
		int last = s.pop();
		insertInReversedStack(s, element);
		// Induction
		s.push(last); // as Stack s is already revered for (size - 1)
	}
}
