class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();

        for (List<String> dict : knowledge) {
            map.put(dict.get(0), dict.get(1));
        }

        StringBuilder res = new StringBuilder();
        int i = 0;
        int n = s.length();

        while (i < n) {
            if (s.charAt(i) == '(') {
                StringBuilder key = new StringBuilder();

                while (i < n && s.charAt(i++) != ')') {
                    key.append(s.charAt(i));
                }
                key.deleteCharAt(key.length() - 1);

                if (map.containsKey(key.toString())) {
                    res.append(map.get(key.toString()));
                } else {
                    res.append("?");
                }
            } else {
                res.append(s.charAt(i++));
            }
        }

        return res.toString();
    }
}