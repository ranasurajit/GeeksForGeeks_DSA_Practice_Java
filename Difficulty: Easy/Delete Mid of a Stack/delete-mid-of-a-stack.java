//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0)
        {
            int sizeOfStack =sc.nextInt();
            Stack <Integer> myStack=new Stack<>();
            
            //adding elements to the stack
            for(int i=0;i<sizeOfStack;i++)
            {
                int x=sc.nextInt();
                myStack.push(x);
                
            }
                Solution obj=new Solution();
                obj.deleteMid(myStack,sizeOfStack);
                
                while(!myStack.isEmpty())
                {
                    System.out.print(myStack.peek()+" ");
                    myStack.pop();
                }
                System.out.println();
        }
        
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    // Function to delete middle element of a stack.
    /**
     * Approach : Using Recursion Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public void deleteMid(Stack<Integer> s) {
        int k = (int) Math.floor((s.size() + 1) / 2);
        // 1 based indexing
        k = s.size() % 2 == 0 ? k : k - 1;
        solveRecursion(s, k); // TC: O(N)
    }
    
    /**
     * TC: O(N / 2) ~ O(N)
     * SC: O(N / 2) ~ O(N)
     */
    private void solveRecursion(Stack<Integer> s, int k) {
        // Base Case
        if (k == 0) {
            // deleting mid of Stack
            s.pop();
            return;
        }
        // Hypothesis - we assume that recursion will delete mid of Stack s [0...(n - 1)]so k decreases by 1
        int lastValue = s.pop();
        solveRecursion(s, k - 1);
        // Induction
        s.push(lastValue);
    }
}

