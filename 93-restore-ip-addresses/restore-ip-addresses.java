class Solution {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if (s.length() > 12) return res;
        solve(0, 0, new StringBuilder(), s);
        return res;
    }

    private void solve(int idx, int dots, StringBuilder sb, String s) {
        if (dots == 4) {
            if (s.length() - sb.length() + 4 > 0) return;
            res.add((sb.deleteCharAt(sb.length() - 1)).toString());
            return;
        }

        for (int i = idx; i < idx + 3 && i < s.length(); i++) {
            String sub = s.substring(idx, i + 1);
            if (isValid(sub)) {
                int len = sb.length();
                sb.append(sub + ".");
                solve(i + 1, dots + 1, sb, s);
                sb.setLength(len);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        return Integer.parseInt(s) < 256;
    }
}