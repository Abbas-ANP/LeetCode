class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return Math.min(hybrid(min, max, nums), Math.min(front(min, max, nums), back(min, max, nums)));
    }

    private int front(int min, int max, int[] nums) {
        int n = nums.length;
        int ops = 0;
        boolean minF = false, maxF = false;

        for (int i = 0; i < n; i++) {
            if (nums[i] == min) {
                minF = true;
            } else if (nums[i] == max) {
                maxF = true;
            }

            ops++;
            if (minF && maxF) break;
        }

        return ops;
    }

    private int back(int min, int max, int[] nums) {
        int n = nums.length;
        int ops = 0;
        boolean minF = false, maxF = false;

        for (int i = n - 1; i > -1; i--) {
            if (nums[i] == min) {
                minF = true;
            } else if (nums[i] == max) {
                maxF = true;
            }

            ops++;
            if (minF && maxF) break;
        }

        return ops;
    }

    private int hybrid(int min, int max, int[] nums) {
        int n = nums.length;
        int ops = 0;
        boolean minF = false, maxF = false;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == min) {
                minF = true;
            } else if (nums[i] == max) {
                maxF = true;
            }

            ops++;
            if (minF || maxF) break;
        }

        int i = n - 1;

        while (minF && !maxF && i > -1) {
            if (nums[i] == max) {
                maxF = true;
            }

            ops++;
            i--;
        }

        while (!minF && maxF && i > -1) {
            if (nums[i] == min) {
                minF = true;
            }

            ops++;
            i--;
        }

        return ops;
    }
}