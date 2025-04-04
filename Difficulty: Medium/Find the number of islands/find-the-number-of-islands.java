class Solution {
    
    private static final int[][] directions = {
        { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 },
        { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }
    };

    /**
     * Approach : Using DFS Approach
     * 
     * TC: O(K x N x M) ~ O(N x M)
     * SC: O(K x N x M) ~ O(N x M)
     * 
     * where K = cells marked as 'L' which in worst case = N x M
     */
    public int countIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m]; // SC: O(N x M)
        int islands = 0;
        for (int i = 0; i < n; i++) { // TC: O(N)
            for (int j = 0; j < m; j++) { // TC: O(M)
                if (!visited[i][j] && grid[i][j] == 'L') {
                    dfsGraph(i, j, grid, visited, n, m); // TC: O(K), SC: O(K)
                    islands++;
                }
            }
        }
        return islands;
    }
    
    /**
     * Using DFS Approach
     * 
     * TC: O(K)
     * SC: O(K)
     * 
     * where K = cells marked as 'L' which in worst case = N x M
     */
    private void dfsGraph(int row, int col, char[][] grid, boolean[][] visited, int n, int m) {
        // validate cells
        if (row < 0 || row >= n || col < 0 || col >= m || visited[row][col] || 
            grid[row][col] == 'W') {
            return;        
        }
        visited[row][col] = true;
        for (int[] direction : directions) {
            dfsGraph(row + direction[0], col + direction[1], grid, visited, n, m);
        }
    }
}
