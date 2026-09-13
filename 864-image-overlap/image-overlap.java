class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int count = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < n; j1++) {
                if (img1[i1][j1] == 1) {
                    for (int i2 = 0; i2 < n; i2++) {
                        for (int j2 = 0; j2 < n; j2++) {
                            if (img2[i2][j2] == 1) {
                                String point = (i1 - i2) + ", " + (j1 - j2);
                                map.put(point, map.getOrDefault(point, 0) + 1);
                                count = Math.max(count, map.get(point));
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}