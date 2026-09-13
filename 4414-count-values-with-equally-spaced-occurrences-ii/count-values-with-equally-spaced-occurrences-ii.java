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

            if (v.size() >= 3) {
                int d = v.get(1) - v.get(0);
                boolean ok = true;

                for (int i = 2; i < v.size(); i++) {
                    if (d != v.get(i) - v.get(i - 1)) {
                        ok = false;
                        break;
                    }
                }

                if (ok) count++;
            }
        }

        return count;
    }
}