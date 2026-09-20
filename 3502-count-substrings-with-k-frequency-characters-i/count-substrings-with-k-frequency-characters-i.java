class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        if (k == 1) return n * (n + 1) / 2;
        int count = 0;
        int l = 0;
        int freq[] = new int[26];

        for (int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            freq[ch - 'a']++;

            while (freq[ch - 'a'] >= k) {
                count += (n - r);
                freq[s.charAt(l++) - 'a']--;
            }
        }

        return count;
    }
}