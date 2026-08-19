class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int res[] : reservedSeats) {
            map.computeIfAbsent(res[0], k -> new HashSet<>()).add(res[1]);
        }

        int count = (n - map.size()) * 2;

        for (Set<Integer> occupied : map.values()) {
            boolean left = !occupied.contains(2) && !occupied.contains(3) && !occupied.contains(4) && !occupied.contains(5);
            boolean middle = !occupied.contains(4) && !occupied.contains(5) && !occupied.contains(6) && !occupied.contains(7);
            boolean right = !occupied.contains(6) && !occupied.contains(7) && !occupied.contains(8) && !occupied.contains(9);

            if (left && right) {
                count += 2;
            } else if (left || middle || right) {
                count++;
            }
        }

        return count;
    }
}