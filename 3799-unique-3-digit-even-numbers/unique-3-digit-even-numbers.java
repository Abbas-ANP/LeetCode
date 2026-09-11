class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length;
        int count = 0;
        boolean vis[] = new boolean[1000];

        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) {
                continue;
            }

            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j || (digits[k] & 1) != 0) {
                        continue;
                    }

                    int digit = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (!vis[digit]) {
                        vis[digit] = true;
                        count++;
                    } 
                }
            }
        }

        return count;
    }
}