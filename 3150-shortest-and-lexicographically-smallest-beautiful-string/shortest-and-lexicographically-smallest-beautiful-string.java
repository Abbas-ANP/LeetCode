class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> 
            s1.length() != s2.length() ? Integer.compare(s1.length() ,s2.length()) : s1.compareTo(s2)
        );

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == '1') count++;
                if (count >= k) pq.offer(s.substring(i, j + 1));
            }
        }

        return pq.isEmpty() ? "" : pq.poll();
    }
}