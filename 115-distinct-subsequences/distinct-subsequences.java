// TC and SC: O(m * n)

class Solution {
    int dp[][];

    public int numDistinct(String s, String t) {    
        dp = new int[s.length() + 1][t.length() + 1];
        
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s.length(), t.length(), s, t);
    }

    private int solve(int m, int n, String s, String t) {
        if (n == 0) {
            return dp[m][n] = 1;
        }

        if (m == 0) {
            return dp[m][n] = 0;
        }

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (s.charAt(m - 1) == t.charAt(n - 1)) {
            return dp[m][n] = solve(m - 1, n - 1, s, t) + solve(m - 1, n, s, t);
        }

        return dp[m][n] = solve(m - 1, n, s, t);
    }
}