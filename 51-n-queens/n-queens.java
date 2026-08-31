class Solution {
    List<List<String>> result;
    int N;

    public List<List<String>> solveNQueens(int n) {
        N = n;
        result = new ArrayList<>();
        char board[][] = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(board, 0);
        return result;
    }

    private void solve(char[][] board, int row) {
        if (row == N) {
            addBoard(board);
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!isAttacked(board, row, col)) {
                // Do
                board[row][col] = 'Q';

                // Explore
                solve(board, row + 1);

                // Undo
                board[row][col] = '.';
            }
        }
    }

    private boolean isAttacked(char[][] board, int row, int col) {
        // row
        for (int r = row - 1; r > -1; r--) {
            if (board[r][col] == 'Q') {
                return true;
            }
        }

        // upper left diagonal
        int r = row - 1, c = col - 1;
        while (r > -1 && c > -1) {
            if (board[r--][c--] == 'Q') {
                return true;
            }
        }

        // upper right diagonal
        r = row - 1; c = col + 1;
        while (r > -1 && c < N) {
            if (board[r--][c++] == 'Q') {
                return true;
            }
        }

        return false;
    }

    private void addBoard(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char row[] : board) {
            list.add(new String(row));
        }

        result.add(new ArrayList<>(list));
    }
}