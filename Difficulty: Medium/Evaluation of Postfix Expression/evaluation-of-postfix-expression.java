//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    /**
     * Using Stack Approach
     * 
     * TC: O(N)
     * SC: O(N)
     */
    public int evaluate(String[] arr) {
        Stack<String> st = new Stack<String>(); // SC: O(N)
        int result = 0;
        for (String s : arr) {                  // TC: O(N)
            if (isOperator(s)) {
                String op = s;
                int operand1 = Integer.valueOf(st.pop());
                int operand2 = Integer.valueOf(st.pop());
                String operation = getResult(operand1, operand2, op);
                st.push(operation);
            } else {
                st.push(s);
            }
        }
        return Integer.valueOf(st.pop());
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
    
    /**
     * TC: O(1)
     * SC: O(1)
     */
    private String getResult(int op1, int op2, String op) {
        int result = 0;
        if (op.equals("+")) {
            result = op2 + op1;
        } else if (op.equals("-")) {
            result = op2 - op1;
        } else if (op.equals("*")) {
            result = op2 * op1;
        } else if (op.equals("/")) {
            result = op2 / op1;
        }
        return String.valueOf(result);
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends