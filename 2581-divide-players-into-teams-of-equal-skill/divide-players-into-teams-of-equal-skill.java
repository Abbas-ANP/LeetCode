class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        Arrays.sort(skill);
        long sum = 0;
        int l = 0, r = n - 1;
        int req = skill[l] + skill[r];

        while (l < r) {
            if (skill[l] + skill[r] == req) {
                sum += skill[l++] * skill[r--];
            } else {
                return -1;
            }
        }

        return sum;
    }
}