class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        int m = n / 2;
        int l = 0, count = 0, size = 0;
        long sum = 0, total = 0;

        for (int num : nums) {
            total += num;
        }

        for (int r = 0; r < n + m; r++) {
            size++;
            sum += nums[r % n];

            while (size > m) {
                sum -= nums[l % n];
                l++; size--;
            }

            // to avoid counting the first rotation again: l < n
            if (size == m && l < n && 2 * sum - total > 0) {
                count++;
            }
        }

        return count;
    }
}