class Solution {
    public String reverseParentheses(String s) {
        Deque<StringBuilder> st = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                st.offerLast(curr);
                curr = new StringBuilder();
            } else if (c == ')') {
                curr.reverse();
                curr = st.pollLast().append(curr);
            } else {
                curr.append(c);
            }
        }

        return curr.toString();
    }
}
