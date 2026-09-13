class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> i1 = new ArrayList<>();
        List<int[]> i2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    i1.add(new int[] {i, j});
                }

                if (img2[i][j] == 1) {
                    i2.add(new int[] {i, j});
                }
            }
        }

        int count = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int p1[] : i1) {
            for (int p2[] : i2) {
                String diff = (p1[0] - p2[0]) + ", " +  (p1[1] - p2[1]);
                map.put(diff, map.getOrDefault(diff, 0) + 1);
                count = Math.max(count, map.get(diff));
            }
        }

        return count;
    }
}