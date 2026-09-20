class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < n; j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
                if (map.get(s.charAt(j)) >= k) {
                    count += (n - j);
                    break;
                }
            }
        }

        return count;
    }
}