class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        if (k == 1) return n * (n + 1) / 2;
        int count = 0;
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.get(ch) >= k) {
                count += (n - r);

                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if (map.get(s.charAt(l)) == 0) map.remove(s.charAt(l));
                l++;
            }
        }

        return count;
    }
}