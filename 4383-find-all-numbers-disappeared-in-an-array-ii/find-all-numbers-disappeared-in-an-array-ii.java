class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        for (int i = lower; i <= upper; i++) {
            List<Integer> curr = new ArrayList<>();
            int num = i;

            if (!set.contains(num)) {
                curr.add(num);
                while (!set.contains(num) && num <= upper) {
                    num++;
                }
                curr.add(num - 1);
                i = num - 1;
            }

            if (!curr.isEmpty())
                list.add(curr);
        }

        return list;
    }
}