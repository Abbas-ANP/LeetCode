class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int curr[] = new int[n];
        Map<Integer, Integer> freq = new HashMap<>();
        int min = 200, max = 0;

        int idx = 0;
        for (int val : s.toCharArray()) {
            curr[idx++] = val;
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            min = Math.min(val, min);
            max = Math.max(val, max);
        }

        boolean isSorted = true;

        for (int i = 1; i < n && isSorted; i++) {
            if (curr[i] < curr[i - 1])
                isSorted = false;
        }

        if (isSorted) return 0;
        if (n == 2) return -1;
        if (curr[0] == min || curr[n - 1] == max) return 1;
        if ((curr[0] == max && freq.get(max) == 1) && (curr[n - 1] == min && freq.get(min) == 1)) return 3;

        return 2;
    }
}