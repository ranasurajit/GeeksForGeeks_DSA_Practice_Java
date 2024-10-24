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
            
            String a = sc.next();
            String b = sc.next();
            Solution ob = new Solution();
            if(ob.isSubSequence(a,b))
            System.out.println(1);
            else
            System.out.println(0);
 		
        
System.out.println("~");
}
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    boolean isSubSequence(String A, String B){
        int m = A.length();
	    int n = B.length();
	    // assume if m > n
	    if (m < n) {
	        return isSubSequence(B, A);
	    }
	    int p = 0; // pointer for String a
	    int q = 0; // pointer for String b
	    while (p < m && q < n) {
	        if (A.charAt(p) == B.charAt(q)) {
	            p++;
	            q++;
	        } else {
	            p++;
	        }
	    }
	    if (q < n) {
	        return false;
	    }
	    return true;
    }
}
