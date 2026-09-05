// TC: O(4^(r * c))
// SC: O(r * c) (recursion stack approx stores all cells)

class Solution {
    int res, R, C, eR, eC, rem;

    public int uniquePathsIII(int[][] grid) {
        res = 0; rem = 0;
        R = grid.length;
        C = grid[0].length;
        eR = -1; eC = -1;

        int r = -1, c = -1;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] != -1) rem++;
                
                if (grid[i][j] == 1) {
                    r = i; c = j;
                }

                if (grid[i][j] == 2) {
                    eR = i; eC = j;
                }
            }
        }

        solve(r, c, rem - 1, grid);
        return res;
    }

    private void solve(int r, int c, int rem, int[][] grid) {
        if (r < 0 || r >= R || c < 0 || c >= C) {
            return;
        }
        
        if (grid[r][c] == -1 || grid[r][c] == 5) {
            return;
        }

        if (r == eR && c == eC) {
            if (rem == 0) res++;
            return;
        }
        
        // do
        int temp = grid[r][c];
        grid[r][c] = 5;
        
        // explore
        solve(r - 1, c, rem - 1, grid);
        solve(r, c - 1, rem - 1, grid);
        solve(r + 1, c, rem - 1, grid);
        solve(r, c + 1, rem - 1, grid);

        // undo
        grid[r][c] = temp;
    }
}