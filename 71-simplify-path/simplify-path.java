class Solution {
    public String simplifyPath(String path) {
        String[] actualPath = path.substring(1).split("/");
        Stack<String> st = new Stack<>();

        for (String str : actualPath) {
            if ("..".equals(str) && !st.isEmpty()) {
                st.pop();
            } else if (!str.equals("") && !str.equals(".") && !str.equals("..")) {
                st.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (String str : st) {
            sb.append("/" + str);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}