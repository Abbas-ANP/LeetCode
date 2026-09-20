class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 2 * n - 1; i > -1; i--) {
            int idx = i % n;

            while (!st.isEmpty() && nums[st.peek()] <= nums[idx]) {
                st.pop();
            }

            res[idx] = (!st.isEmpty() && i < n) ? nums[st.peek()] : -1;
            st.push(idx);
        }

        return res;
    }
}