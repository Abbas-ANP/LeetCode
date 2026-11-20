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
                res.add(new ArrayList<>(Arrays.asList(s1.substring(s, i), s2.substring(s, i))));
            } else {
                i++;
            }
        }

        return res;
    }
}