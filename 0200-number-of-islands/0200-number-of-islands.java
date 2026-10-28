class Solution {

    private void dfs (char[][] grid, int row , int col) {
        int m = grid.length;
        int n = grid[0].length; 

        // boundry check karna hai

        if (row < 0 || col < 0 || row >= m || col >= n || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        // check all 4 direction
        dfs(grid, row - 1, col );
        dfs(grid, row + 1, col );
        dfs(grid, row , col - 1 );
        dfs(grid, row , col + 1);
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid,i, j);
                }
            }
        }

        return count;
    }
}