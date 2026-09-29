class Solution {
    int dp[][][];
    int r, c;

    private boolean rec(int i, int j, int balance, char[][] grid) {
        if (i >= r || j >= c || balance < 0) {
            return false;
        }

        if (i == r - 1 && j == c - 1) {
            if (grid[i][j] == '(') balance++;
            else balance--;
            return balance == 0;
        }

        if (dp[i][j][balance] != -1) {
            return dp[i][j][balance] == 1;
        }

        boolean res;

        if (grid[i][j] == '(') {
            res = rec(i + 1, j, balance + 1, grid) || rec(i, j + 1, balance + 1, grid);
        } else {
            res = rec(i + 1, j, balance - 1, grid) || rec(i, j + 1, balance - 1, grid);
        }

        dp[i][j][balance] = res ? 1 : 0;
        return res;
    }

    public boolean hasValidPath(char[][] grid) {
        r = grid.length;
        c = grid[0].length;

        dp = new int[r][c][r + c + 1];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return rec(0, 0, 0, grid);
    }
}