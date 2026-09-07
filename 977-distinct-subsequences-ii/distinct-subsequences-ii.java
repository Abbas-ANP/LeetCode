class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;

        // store the last occurence of each character up until i - 1
        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int x = s.charAt(i) - 'a';

            // for no dups, it is twice the previous (grows 2^n)
            dp[i + 1] = dp[i] * 2 % mod;

            // have to remove the dups
            if (last[x] >= 0) {
                dp[i + 1] = (dp[i + 1] - dp[last[x]] + mod) % mod;
            }

            // update last occurence
            last[x] = i;
        }

        // exclude ""
        return (dp[n] - 1 + mod) % mod;
    }
}