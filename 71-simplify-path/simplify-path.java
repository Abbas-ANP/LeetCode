class Solution {
    public String simplifyPath(String path) {
        String[] actualPath = path.substring(1).split("/");
        Deque<String> st = new ArrayDeque<>();

        for (String str : actualPath) {
            if ("..".equals(str) && !st.isEmpty()) {
                st.pollLast();
            } else if (!str.equals("") && !str.equals(".") && !str.equals("..")) {
                st.offerLast(str);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String str : st) {
            sb.append("/" + str);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}