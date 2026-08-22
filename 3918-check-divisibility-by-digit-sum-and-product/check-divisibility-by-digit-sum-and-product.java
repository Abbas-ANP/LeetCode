class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, pro = 1, temp = n;

        while (temp > 0) {
            sum += temp % 10;
            pro *= temp % 10;
            temp /= 10;
        }

        return (n % (sum + pro) == 0);
    }
}