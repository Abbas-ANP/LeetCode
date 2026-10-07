class Solution {
    int maxLen = -1;
    Set<String> set;

    public List<String> removeInvalidParentheses(String s) {
        set = new HashSet<>();
        solve(new StringBuilder(), 0, 0, 0, s);
        return new ArrayList<>(set);
    }

    private void solve(StringBuilder curr, int open, int close, int idx, String s) {
        if (idx == s.length()) {
            if (open == close) {
                if (curr.length() > maxLen) {
                    maxLen = curr.length();
                    set.clear();
                    set.add(curr.toString());
                } else if (curr.length() == maxLen) {
                    set.add(curr.toString());
                }
            }
            return;
        }

        if (close > open) {
            return;
        }

        char ch = s.charAt(idx);
        
        // pick
        curr.append(ch);
        solve(curr, ch == '(' ? open + 1 : open, ch == ')' ? close + 1 : close, idx + 1, s);
        curr.deleteCharAt(curr.length() - 1);

        // skip
        solve(curr, open, close, idx + 1, s);
    }
}