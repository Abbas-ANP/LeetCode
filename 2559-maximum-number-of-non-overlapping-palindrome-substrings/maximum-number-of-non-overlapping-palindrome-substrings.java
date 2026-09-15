class Solution {
    int dp[][];
    int K;

    public int maxPalindromes(String s, int k) {
        if (k == 1) return s.length();
        dp = new int[2001][2001];
        K = k;

        for (int i = 0; i < 2001; i++) {
            for (int j = 0; j < 2001; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(0, k - 1, s);
    }

    private int solve(int i, int j, String s) {
        if (i >= s.length() || j >= s.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // if substring is palindrome then the subproblems are: take and re-init the window, grow the window, and slide the window
        if (isPalindrome(s, i, j)) {
            int take = 1 + solve(j + 1, j + K, s);
            int grow = solve(i, j + 1, s);
            int slide = solve(i + 1, j + 1, s);

            return dp[i][j] = Math.max(take, Math.max(grow, slide));
        }

        // we do not take and re-init the window as the substring isn't a palindrome
        int grow = solve(i, j + 1, s);
        int slide = solve(i + 1, j + 1, s);

        return dp[i][j] = Math.max(grow, slide);
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}