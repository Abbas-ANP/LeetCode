class Solution {
    public long countCommas(long n) {
        long base = 1000;
        long res = 0;

        while (base <= n) {
            res += n - base + 1;
            base *= 1000;
        }

        return res;
    }
}