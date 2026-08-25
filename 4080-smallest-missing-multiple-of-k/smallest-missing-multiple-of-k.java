class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int m = k;

        while (!set.isEmpty()) {
            if (!set.contains(m)) return m;
            set.remove(m);
            m += k;
        }

        return m;
    }
}