class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        long[][] dp = new long[n + 1][5];
        List<Integer>[][] idxs = new List[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                idxs[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < n; i++) {
            int l = arr[i][0], weight = arr[i][2], idx = arr[i][3];
            // find intervals whose right endpoints are smaller than l
            int k = bs(arr, i, l);

            for (int j = 1; j < 5; j++) {
                long s1 = dp[i][j];
                long s2 = dp[k][j - 1] + weight;

                if (s1 > s2) {
                    dp[i + 1][j] = dp[i][j];
                    idxs[i + 1][j] = new ArrayList<>(idxs[i][j]);
                    continue;
                }

                List<Integer> newIndex = new ArrayList<>(idxs[k][j - 1]);
                newIndex.add(idx);
                Collections.sort(newIndex);

                if (s1 == s2 && compareLists(idxs[i][j], newIndex) < 0) {
                    newIndex = new ArrayList<>(idxs[i][j]);
                }

                dp[i + 1][j] = s2;
                idxs[i + 1][j] = newIndex;
            }
        }

        List<Integer> result = idxs[n][4];
        int[] ans = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private int bs(int[][] arr, int end, int target) {
        int l = 0, r = end;

        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m][1] < target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }

    private int compareLists(List<Integer> a, List<Integer> b) {
        int minLen = Math.min(a.size(), b.size());

        for (int i = 0; i < minLen; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }
}