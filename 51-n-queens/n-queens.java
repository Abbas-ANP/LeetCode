class Solution {
    List<List<String>> result;
    int N;

    public List<List<String>> solveNQueens(int n) {
        N = n;
        result = new ArrayList<>();
        List<String> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }

        solve(board, 0);
        return result;
    }

    private void solve(List<String> board, int row) {
        if (row == N) {
            result.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!isAttacked(board, row, col)) {
                // Do
                String t = board.get(row);
                t = t.substring(0, col) + 'Q' + t.substring(col + 1);
                board.remove(row);
                board.add(row, t);

                // Explore
                solve(board, row + 1);

                // Undo
                t = t.substring(0, col) + '.' + t.substring(col + 1);
                board.remove(row);
                board.add(row, t);
            }
        }
    }

    private boolean isAttacked(List<String> board, int row, int col) {
        // row
        for (int r = row - 1; r > -1; r--) {
            if (board.get(r).charAt(col) == 'Q') {
                return true;
            }
        }

        // upper left diagonal
        int r = row - 1, c = col - 1;
        while (r > -1 && c > -1) {
            if (board.get(r--).charAt(c--) == 'Q') {
                return true;
            }
        }

        // upper right diagonal
        r = row - 1; c = col + 1;
        while (r > -1 && c < N) {
            if (board.get(r--).charAt(c++) == 'Q') {
                return true;
            }
        }

        return false;
    }
}