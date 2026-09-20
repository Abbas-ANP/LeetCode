class Solution {
    public long countIntersectingIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        long count = 0;

        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n - 1;
            int max = i;

            while (l <= r) {
                int m = l + (r - l) / 2;

                if (intervals[m][0] <= intervals[i][1]) {
                    max = m;
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }

            count += max - i;
        }

        return count;
    }
}