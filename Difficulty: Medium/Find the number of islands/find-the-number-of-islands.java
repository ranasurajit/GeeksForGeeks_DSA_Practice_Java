int[][] directions = { 
    {-1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, 
    { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }
};

/**
 * TC: O(N x M)
 * SC: O(N x M) -  Recursion Stack space
 * DFS take TC: O(N x M) as it visits all the grid cells
 */
public int numIslands(char[][] grid) {
    int n = grid.length;
    int m = grid[0].length;
    int countIslands = 0;
    for (int i = 0; i < n; i++) { // TC: O(N)
        for (int j = 0; j < m; j++) { // TC: O(M)
            if (grid[i][j] == '1') {
                dfsGraph(i, j, n, m, grid);
                countIslands++;
            }
        }
    }
    return countIslands;
}

private void dfsGraph(int i, int j, int rows, int cols, char[][] grid) {
    if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
        return;
    }
    grid[i][j] = '0';
    // move in all 8 directions
    for (int[] dir : directions) {
        dfsGraph(i + dir[0], j + dir[1], rows, cols, grid);
    }
}
