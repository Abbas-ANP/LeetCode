class Solution {
    int dp[];

    public int fib(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        f(n);
        return dp[n];
    }

    private int f(int n) {
        if (n <= 1) {
            return dp[n] = n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = f(n - 1) + f(n - 2);
    }
}