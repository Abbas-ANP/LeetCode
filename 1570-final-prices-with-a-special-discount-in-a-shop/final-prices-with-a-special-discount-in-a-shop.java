class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int res[] = Arrays.copyOf(prices, n);
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = n - 1; i > -1; i--) {
            while (!st.isEmpty() && prices[st.peek()] > prices[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                res[i] = prices[i] - prices[st.peek()];
            }

            st.push(i);
        }

        return res;
    }
}