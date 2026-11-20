class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> res = new ArrayList<>();
        if (s1.equals(s2)) return res;

        int n = s1.length();
        int i = 0;

        while (i < n) {
            int s = i;
            while (i < n && s1.charAt(i) != s2.charAt(i)) i++;

            if (s - i != 0) {
                List<String> curr = new ArrayList<>();
                curr.add(s1.substring(s, i));
                curr.add(s2.substring(s, i));
                res.add(curr);
            } else {
                i++;
            }
        }

        return res;
    }
}