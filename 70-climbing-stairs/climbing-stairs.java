class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int prev2 = 1; // 0th step
        int prev1 = 1; // 1st step

        for (int i = 2; i <= n; i++) {
            int curr = prev2 + prev1;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}