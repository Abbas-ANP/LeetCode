class Solution {
    public int arraySign(int[] nums) {
        int times = 0;
        boolean has = false;
        for (int num : nums) {
            if (num == 0) {
                has = true;
                break;
            }
            
            if (num < 0) times++;
        }

        if (has) return 0;

        return (times & 1) == 0 ? 1 : -1;
    }
}