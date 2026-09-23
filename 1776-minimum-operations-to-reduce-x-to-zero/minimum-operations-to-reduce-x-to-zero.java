class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;

        int tar = sum - x;

        if (tar < 0) return -1;
        if (tar == 0) return n;

        // find the longest sub array so that when we do n - longest, we'll get min number of ops required
        int l = 0, currSum = 0, max = -1;

        for (int r = 0; r < n; r++) {
            currSum += nums[r];

            while (l <= r && currSum > tar) {
                currSum -= nums[l++];
            }

            if (currSum == tar) {
                max = Math.max(max, r - l + 1);
            }
        }

        return max == -1 ? -1 : n - max;
    }
}