class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int freq[] = new int[26];

            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'a']++;

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int num : freq) {
                    if (num == 0) continue;
                    min = Math.min(min, num);
                    max = Math.max(max, num);
                }

                sum += (max - min);
            }
        }

        return sum;
    }
}