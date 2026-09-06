class Solution {
    int dp[][];

    public int numDistinct(String s, String t) {    
        dp = new int[1001][1001];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, 0, s, t);
    }

    private int solve(int i, int j, String s, String t) {
        if (j == t.length()) {
            return dp[i][j] = 1;
        }

        if (i == s.length()) {
            return dp[i][j] = 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = solve(i + 1, j + 1, s, t) + solve(i + 1, j, s, t);
        }

        return dp[i][j] = solve(i + 1, j, s, t);
    }
}