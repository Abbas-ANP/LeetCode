class Solution {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return res;
        solve(0, 0, new StringBuilder(), s);
        return res;
    }

    private void solve(int idx, int dots, StringBuilder sb, String s) {
        if (dots == 4) {
            // diff bet sb and s must be equal excluding the dots in sb
            if (s.length() - sb.length() + 4 > 0) return;
            res.add((sb.deleteCharAt(sb.length() - 1)).toString());
            return;
        }

        // i < idx + 3 and i < s.length()
        for (int i = idx; i < Math.min(idx + 3, s.length()); i++) {
            String sub = s.substring(idx, i + 1);
            if (isValid(sub)) {
                int len = sb.length();
                // Do
                sb.append(sub + ".");
                
                // Explore
                solve(i + 1, dots + 1, sb, s);
                
                // Undo
                sb.setLength(len);
            }
        }
    }

    private boolean isValid(String s) {
        // 0 shouldn't be the first character (if len > 2) and num <= 255 
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        return Integer.parseInt(s) < 256;
    }
}