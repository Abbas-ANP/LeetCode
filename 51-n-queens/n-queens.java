// Exploiting the properties of matrix: If a queen is to be placed in a cell, instead of checking upper rows, upper neg diag, and upper pos diag manually, we maintain three sets to check if the col / neg diag / pos diag are already occupied.

// colLock.add(col)
// negDiagLock.add(row - col)
// posDiagLock.add(row + col)

// TC : Approx O(n!) (generally faster than that)
// SC : O(n^2) (excluding the output space: board -> n^2, sets -> 3*n)

class Solution {
    List<List<String>> result;
    Set<Integer> colLock, negDiagLock, posDiagLock;
    int N;

    public List<List<String>> solveNQueens(int n) {
        N = n;
        result = new ArrayList<>();
        colLock = new HashSet<>();
        negDiagLock = new HashSet<>();
        posDiagLock = new HashSet<>();

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

    private void addBoard(char[][] board) {
        List<String> list = new ArrayList<>();

        for (char row[] : board) {
            list.add(new String(row));
        }

        result.add(list);
    }
}