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
                int start = i + 1;
                while (s.charAt(i++) != ')') continue;
                String key = s.substring(start, i - 1);


                if (map.containsKey(key)) {
                    res.append(map.get(key));
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