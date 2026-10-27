class Solution {
    public String[] createGrid(int m, int n) {
        String topRow = ".".repeat(n);
        String restRows = "#".repeat(n - 1) + '.';
        String[] grid = new String[m];
        grid[0] = topRow;

        for (int i = 1; i < m; i++) {
            grid[i] = restRows;
        }

        return grid;
    }
}