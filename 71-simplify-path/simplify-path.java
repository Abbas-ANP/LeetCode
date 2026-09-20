class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.substring(1).split("/");
        Deque<String> st = new ArrayDeque<>();

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) continue;

            if (part.equals("..")) {
                if (!st.isEmpty()) {
                    st.pollLast();
                }
            } else {
                st.offerLast(part);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!st.isEmpty()) {
            sb.append("/").append(st.pop());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}