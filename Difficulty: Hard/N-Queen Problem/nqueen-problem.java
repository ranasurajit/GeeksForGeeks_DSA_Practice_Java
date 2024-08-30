//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        // create the board
        List<String> board = buildBoard(n);
        Set<Integer> colSet = new HashSet<Integer>();
        Set<Integer> diagSet = new HashSet<Integer>();
        Set<Integer> antiDiagSet = new HashSet<Integer>();
        solve(board, 0, colSet, diagSet, antiDiagSet, result); // row = 0
        return result;
    }
    
    private void solve(List<String> board, int row, Set<Integer> colSet,
        Set<Integer> diagSet, Set<Integer> antiDiagSet, 
        ArrayList<ArrayList<Integer>> result) {
        if (row >= board.size()) {
            ArrayList<Integer> queens = new ArrayList<Integer>();
            for (int i = 0; i < board.size(); i++) {
                for (int j = 0; j < board.size(); j++) {
                    StringBuilder sb = new StringBuilder(board.get(i));
                    if (sb.charAt(j) == 'Q') {
                        queens.add(j + 1);
                    }
                }
            }
            result.add(queens);
            return;
        }
        for (int col = 0; col < board.size(); col++) {
            int diagId = row + col;
            int antiDiagId = row - col;
            if (colSet.contains(col) || diagSet.contains(diagId) || 
                antiDiagSet.contains(antiDiagId)) {
                continue;        
            }
            // explore
            colSet.add(col);
            diagSet.add(diagId);
            antiDiagSet.add(antiDiagId);
            StringBuilder sb = new StringBuilder(board.get(row));
            sb.setCharAt(col, 'Q');
            board.set(row, new String(sb));
            // recursion call
            solve(board, row + 1, colSet, diagSet, antiDiagSet, result);
            // backtrack
            colSet.remove(col);
            diagSet.remove(diagId);
            antiDiagSet.remove(antiDiagId);
            sb.setCharAt(col, '.');
            board.set(row, new String(sb));
        }
    }
    
    private List<String> buildBoard(int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            board.add(new String(sb));
        }
        return board;
    }

}
