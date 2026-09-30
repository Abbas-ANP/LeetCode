class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] res = new int[n];
        int depth = 0;

        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                // Level of '(' is after opening
                depth++;
                res[i] = depth & 1;
                continue;
            }

            // Level of ')' is before closing
            res[i] = depth & 1;
            depth--;
        }

        return res;
    }
}