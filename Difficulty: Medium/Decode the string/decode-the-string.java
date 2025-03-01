//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends



class Solution {
    /**
     * TC: O(K x N)
     * SC: O(N)
     */
    static String decodeString(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < n; i++) { // TC: O(N)
            char ch = s.charAt(i);
            if (ch != ']') {
                st.push(ch);
            } else {
                StringBuilder temp = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '[') {
                    temp.insert(0, st.pop());
                }
                st.pop(); // remove '[' from stack
                StringBuilder num = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    num.insert(0, st.pop());
                }
                int k = Integer.valueOf(num.toString());
                StringBuilder word = new StringBuilder();
                while (k-- > 0) {
                    word.append(temp);
                }
                for (int j = 0; j < word.length(); j++) {
                    st.push(word.charAt(j));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}
