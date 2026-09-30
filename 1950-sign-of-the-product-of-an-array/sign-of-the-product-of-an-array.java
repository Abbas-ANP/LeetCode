class Solution {
    public int arraySign(int[] nums) {
        int times = 0;
        
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) times++;
        }

        return (times & 1) == 0 ? 1 : -1;
    }
}