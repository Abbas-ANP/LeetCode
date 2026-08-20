class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] n1 = new int[n];
        int[] n2 = new int[n];
        Arrays.fill(n1, -1);
        Arrays.fill(n2, -1);

        n1[0] = nums[0];
        n2[0] = nums[1];

        int i1 = 1, i2 = 1;

        for (int i = 2; i < n; i++) {
            if (n1[i1 - 1] > n2[i2 - 1]) {
                n1[i1++] = nums[i];
            } else {
                n2[i2++] = nums[i];
            }
        }

        int i = 0;

        for (int num : n1) {
            if (num != -1) nums[i++] = num;
        }

        for (int num : n2) {
            if (num != -1) nums[i++] = num;
        }

        return nums;
    }
}