class Solution {
    List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        solve(0, s, new ArrayList<>());
        return res;
    }

    private void solve(int idx, String s, List<String> list) {
        if (idx == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPal(s, idx, i)) {
                list.add(s.substring(idx, i + 1));
                solve(i + 1, s, list);
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPal(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }

        return true;
    }
}