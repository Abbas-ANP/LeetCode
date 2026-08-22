class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int moves = 0;
        int med = (n % 2 == 0) ? (nums[n / 2] + nums[n / 2 - 1]) / 2 : nums[n / 2];

        for (int num : nums) {
            moves += Math.abs(med - num);
        }

        return moves;
    }
}