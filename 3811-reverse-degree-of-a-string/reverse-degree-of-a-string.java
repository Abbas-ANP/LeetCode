class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int degree = 0;

        for (int i = 0; i < n; i++) {
            degree += (i + 1) * ('z' - s.charAt(i) + 1);
        }

        return degree;
    }
}