class Solution {
    public int maxDepth(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int max = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') stack.offerLast(ch);
            else if (ch == ')') stack.pollLast();
            max = Math.max(stack.size(), max);
        }

        return max;
    }
}