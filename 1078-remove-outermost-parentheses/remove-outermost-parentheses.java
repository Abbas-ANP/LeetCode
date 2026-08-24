class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                count++;
                // indicates we are inside a valid primitive
                if (count > 1) {
                    sb.append('(');
                }
            } else {
                count--;
                // indicates we are still inside a valid primitive
                if (count > 0) {
                    sb.append(')');
                }
            }
        }

        return sb.toString();
    }
}