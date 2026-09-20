class StockSpanner {
    Deque<int[]> st;

    public StockSpanner() {
        st = new ArrayDeque<>();    
    }
    
    public int next(int price) {
        int span = 1;

        while (!st.isEmpty() && st.peekLast()[0] <= price) {
            span += st.pollLast()[1];
        }

        st.offerLast(new int[] { price, span });

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */