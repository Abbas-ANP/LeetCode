class Solution {
    int res, R, C, eR, eC, total;

    public int uniquePathsIII(int[][] grid) {
        res = 0;
        total = 0;
        R = grid.length;
        C = grid[0].length;
        eR = -1; eC = -1;

        int r = -1, c = -1;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] != -1) total++;
                
                if (grid[i][j] == 1) {
                    r = i; c = j;
                }

                if (grid[i][j] == 2) {
                    eR = i; eC = j;
                }
            }
        }

        solve(1, r, c, grid);
        return res;
    }

    private void solve(int count, int r, int c, int[][] grid) {
        if (r < 0 || r >= R || c < 0 || c >= C) {
            return;
        }
        
        if (grid[r][c] == -1 || grid[r][c] == 5) {
            return;
        }

        if (r == eR && c == eC) {
            if (count == total) res++;
            return;
        }
        
        // do
        int temp = grid[r][c];
        grid[r][c] = 5;
        
        // explore
        solve(count + 1, r - 1, c, grid);
        solve(count + 1, r, c - 1, grid);
        solve(count + 1, r + 1, c, grid);
        solve(count + 1, r, c + 1, grid);

        // undo
        grid[r][c] = temp;
    }
}