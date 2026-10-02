class Solution {
    List<String> list;

    public List<String> generateParenthesis(int n) {
        list = new ArrayList<>();
        generate(n, new StringBuilder(), 0, 0);
        return list;    
    }

    private void generate(int n, StringBuilder curr, int open, int close) {
        if (curr.length() == 2 * n) {
            list.add(curr.toString());
            return;
        }

        if (open < n) {
            generate(n, curr.append('('), open + 1, close);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (close < open) {
            generate(n, curr.append(')'), open, close + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}