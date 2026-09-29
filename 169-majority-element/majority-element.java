class Solution {
    public int majorityElement(int[] nums) {
        int el = nums[0];
        int c = 1;

        for (int num : nums) {
            if (num == el) c++;
            else {
                if (c <= 1) {
                    el = num;
                } else {
                    c--;
                }
            }
        }

        return el;
    }
}