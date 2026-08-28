class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows <= 1 || n <= numRows) return s;

        int uni = 2 * (numRows - 1);
        StringBuilder res = new StringBuilder();

        for (int r = 0; r < numRows; r++) {
            if (r == 0 || r == numRows - 1) {
                int idx = r;

                while (idx < n) {
                    res.append(s.charAt(idx));
                    idx += uni;
                }
            } else {
                int f1 = uni - 2 * r;
                int f2 = Math.abs(uni - f1);
                int idx = r;
                int turn = 0;
                
                while (idx < n) {
                    res.append(s.charAt(idx));
                    idx = (turn % 2 == 0) ? idx + f1 : idx + f2;
                    turn++;
                }
            }
        }

        return res.toString();
    }
}