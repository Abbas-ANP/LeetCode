class Solution {
    static long mod = (long) 1e9 + 7;

    public long myPow(long x, long n) {
        if (n == 0 || x == 1) return 1;
        if (n == 1) return x;

        return pow(x % mod, n) % mod;
    }

    private long pow(long x, long n) {
        if (n == 0) {
            return 1;
        }

        if ((n & 1) == 0) {
            return pow(((x % mod) * (x % mod)) % mod, n / 2);
        }

        return (x * pow(((x % mod) * (x % mod)) % mod, n / 2)) % mod;
    }

    public int sumDecoded(long[] nums) {
        long sum = 0;

        for (long num : nums) {
            long w = num % 10;
            long d = (long) Math.floor(num / 10);
            String n = String.valueOf(d);

            long x = Long.parseLong(n.substring(0, (int) w));
            long y = Long.parseLong(n.substring((int) w));

            sum = (sum + myPow(x, y)) % mod;
        }

        return (int) sum;
    }
}