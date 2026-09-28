class Solution {
    public int maxDepth(String s) {
        int o = 0, max = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') o++;
            else if (ch == ')') o--;
            max = Math.max(max, o);
        }

        return max;
    }
}