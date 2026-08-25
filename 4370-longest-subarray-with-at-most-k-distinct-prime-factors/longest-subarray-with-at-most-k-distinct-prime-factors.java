class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, List<Integer>> primeFactors = new HashMap<>();

        for (int num : nums) {
            primeFactors.put(num, getPrimeFactors(num));
        }

        int max = 0;
        int l = 0;
        Map<Integer, Integer> window = new HashMap<>();

        for (int r = 0; r < n; r++) {
            for (int pf : primeFactors.get(nums[r])) {
                window.put(pf, window.getOrDefault(pf, 0) + 1);
            }

            while (window.size() > k) {
                for (int pf : primeFactors.get(nums[l])) {
                    window.put(pf, window.get(pf) - 1);
                    if (window.get(pf) <= 0) window.remove(pf);
                }

                l++;
            }

            max = Math.max(max, r - l + 1);
        }

        return max;
    }

    // Euler's phi -> produces distinct prime factors
    private List<Integer> getPrimeFactors(int n) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);

                while (n % i == 0) {
                    n /= i;
                }
            }
        }

        if (n > 1) {
            list.add(n);
        }

        return list;
    }
}