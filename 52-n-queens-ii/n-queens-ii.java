class Solution {
    int count;
    Set<Integer> colLock, negDiagLock, posDiagLock;
    int N;

    public int totalNQueens(int n) {
        N = n;
        count = 0;
        colLock = new HashSet<>();
        negDiagLock = new HashSet<>();
        posDiagLock = new HashSet<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(board, 0);
        return count;
    }

    private void solve(char[][] board, int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!colLock.contains(col) && !negDiagLock.contains(row - col) && !posDiagLock.contains(row + col)) {
                // Do
                board[row][col] = 'Q';
                colLock.add(col); negDiagLock.add(row - col); posDiagLock.add(row + col);

                // Explore
                solve(board, row + 1);

                // Undo
                board[row][col] = '.';
                colLock.remove(col); negDiagLock.remove(row - col); posDiagLock.remove(row + col);
            }
        }
    }
}