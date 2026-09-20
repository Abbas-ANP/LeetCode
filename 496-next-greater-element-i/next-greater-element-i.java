class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> st = new ArrayDeque<>();
        int res[] = new int[n1];
        Arrays.fill(res, -1);

        for (int i = 0; i < n1; i++) {
            map.put(nums1[i], i);
        }

        for (int num : nums2) {
            while (!st.isEmpty() && st.peek() <= num) {
                int n = st.pop();

                if (map.containsKey(n)) {
                    res[map.get(n)] = num;
                }
            }

            st.push(num);
        }

        return res;
    }
}