class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int o = 0, c = 0;
        int max = 0;

        // l to r: reset on extra )
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') o++;
            else c++;

            if (o == c) {
                max = Math.max(max, o + c);
            } else if (c > o) {
                o = 0; c = 0;
            }
        }

        o = 0; c = 0;

        // r to l: reset on extra (
        for (int i = n - 1; i > -1; i--) {
            char ch = s.charAt(i);
            if (ch == '(') o++;
            else c++;

            if (o == c) {
                max = Math.max(max, o + c);
            } else if (o > c) {
                o = 0; c = 0;
            }
        }

        return max;
    }
}