class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;
        String maxPal = "";

        for (int i = 1; i < n; i++) {
            // Odd length
            int l = i, r = i;
            while (l > -1 && r < n && s.charAt(l) == s.charAt(r)) {
                l--; r++;
            }

            String pal = s.substring(l + 1, r);
            if (pal.length() > maxPal.length()) {
                maxPal = pal;
            }

            // Even length
            l = i - 1; r = i;
            while (l > -1 && r < n && s.charAt(l) == s.charAt(r)) {
                l--; r++;
            }

            pal = s.substring(l + 1, r);
            if (pal.length() > maxPal.length()) {
                maxPal = pal;
            }
        }

        return maxPal;
    }
}