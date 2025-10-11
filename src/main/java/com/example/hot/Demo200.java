package com.example.hot;

public class Demo200 {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        int i = new Demo200().numIslands(grid);
        System.out.println(i);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int count = 0;

        int x = grid.length;
        int y = grid[0].length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }


            }
        }
        return count;
    }

    public void dfs(char[][] grid, int x, int y) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (x < 0 || y < 0 || x >= nr || y >= nc || grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        dfs(grid, x - 1, y);
        dfs(grid, x, y - 1);
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);

    }
}
