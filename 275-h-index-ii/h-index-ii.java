class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (citations[n - 1] == 0) return 0;

        int l = 0, r = n - 1;

        while (l < r) {
            int m = l + (r - l) / 2;

            if (n - m <= citations[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return n - l;
    }
}