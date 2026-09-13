class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.computeIfAbsent(nums[i], k -> new ArrayList<>())).add(i);
        }

        int count = 0;

        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            List<Integer> v = e.getValue();

            if (v.size() == 3) {
                if (2 * v.get(1) - v.get(0) - v.get(2) == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}