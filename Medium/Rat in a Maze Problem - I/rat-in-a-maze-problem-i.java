//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        int n = mat.length;
        boolean[][] visited = new boolean[n][n];
        ArrayList<String> paths = new ArrayList<String>();
        helper(mat, visited, n, 0, 0, "", paths);
        return paths;
    }
    
    private void helper(int[][] mat, boolean[][] visited, int n, int row, 
        int col, String current, ArrayList<String> paths) {
        if (mat[row][col] == 0 || visited[row][col]) {
            return;
        }
        if (row == n - 1 && col == n - 1) {
            paths.add(current);
            return;
        }
        visited[row][col] = true;
        // moving to directions
        // up
        if (row > 0) {
            helper(mat, visited, n, row - 1, col, current + "U", paths);
        }
        // down
        if (row < n - 1) {
            helper(mat, visited, n, row + 1, col, current + "D", paths);
        }
        // left
        if (col > 0) {
            helper(mat, visited, n, row, col - 1, current + "L", paths);
        }
        // right
        if (col < n - 1) {
            helper(mat, visited, n, row, col + 1, current + "R", paths);
        }
        // backtracking visited so that other directions can be explored
        visited[row][col] = false;
    }
}
