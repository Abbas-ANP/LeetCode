class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int res[] = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i > -1; i--) {
            while (!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]) {
                st.pop();
            }

            res[i] = !st.isEmpty() ? st.peek() - i : 0;
            st.push(i);
        }

        return res;
    }
}