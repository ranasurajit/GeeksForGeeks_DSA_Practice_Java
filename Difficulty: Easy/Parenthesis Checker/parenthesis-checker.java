//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution {
    //Function to check if brackets are balanced or not.
    /**
     * TC: O(N)
     * SC: O(N)
     */
    static boolean ispar(String x) {
        int n = x.length();
        Stack<Character> st = new Stack<Character>(); // SC: O(N)
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = x.charAt(i);
            if (isOpenBrace(ch)) {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                } else {
                    char c = st.pop();
                    if (!isClosedForOpen(c, ch)) {
                        return false;
                    }
                }
            }
        }
        if (!st.isEmpty()) {
            return false;
        }
        return true;
    }
    
    private static boolean isOpenBrace(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }
    
    private static boolean isClosedForOpen(char open, char closed) {
        if (closed == ')') {
            return open == '(';
        } else if (closed == '}') {
            return open == '{';
        } else if (closed == ']') {
            return open == '[';
        }
        return false;
    }
}
