class Solution {
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private long dfs(int i, int j, int r, int c, int[][] grid) {
        long sum = grid[i][j];
        grid[i][j] = 0;

        for (int[] dir : dirs) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];

            if (i_ >= 0 && i_ < r && j_ >= 0 && j_ < c && grid[i_][j_] > 0) {
                sum += dfs(i_, j_, r, c, grid);
            }
        }

        return sum;
    }

    public int countIslands(int[][] grid, int k) {
        int count = 0;
        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] > 0) {
                    long sum = dfs(i, j, r, c, grid);
                    
                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}