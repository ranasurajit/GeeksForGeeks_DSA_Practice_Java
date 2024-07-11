//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {

    public int MaxConnection(int grid[][]) {
        int n = grid.length;
        int islandSize = 2;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfsGraph(grid, n, i, j, islandSize);
                    hm.put(islandSize, size);
                    result = Math.max(result, size);
                    islandSize++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Set<Integer> hs = new HashSet<Integer>();
                int maxSize = 0;
                if (grid[i][j] == 0) {
                    if (i > 0) {
                        hs.add(grid[i - 1][j]);
                    }
                    if (i < n - 1) {
                        hs.add(grid[i + 1][j]);
                    }
                    if (j > 0) {
                        hs.add(grid[i][j - 1]);
                    }
                    if (j < n - 1) {
                        hs.add(grid[i][j + 1]);
                    }
                }
                for (Integer it : hs) {
                    maxSize += hm.get(it) == null ? 0 : hm.get(it);
                }
                maxSize++;
                result = Math.max(result, maxSize);
            }
        }
        return result;
    }
    
    private int dfsGraph(int[][] grid, int n, int i, int j, int islandSize) {
        if (i < 0 || j < 0 || i > n - 1 || j > n - 1 || 
            grid[i][j] == 0 || grid[i][j] == islandSize) {
            return 0;
        }
        grid[i][j] = islandSize;
        int a = dfsGraph(grid, n, i - 1, j, islandSize);
        int b = dfsGraph(grid, n, i, j - 1, islandSize);
        int c = dfsGraph(grid, n, i + 1, j, islandSize);
        int d = dfsGraph(grid, n, i, j + 1, islandSize);
        return 1 + a + b + c + d;
    }
}
