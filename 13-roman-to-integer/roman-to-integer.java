class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> m1 = new HashMap<>();
        m1.put('I', 1); m1.put('V', 5); m1.put('X', 10); m1.put('L', 50); m1.put('C', 100); m1.put('D', 500); m1.put('M', 1000);

        Map<String, Integer> m2 = new HashMap<>();
        m2.put("IV", 4); m2.put("IX", 9); m2.put("XL", 40); m2.put("XC", 90); m2.put("CD", 400); m2.put("CM", 900);

        int n = s.length();
        int num = 0;

        for (int i = n - 1; i > -1; i--) {
            boolean flag = false;
            if (i > 0 && m2.containsKey(s.substring(i - 1, i + 1))) {
                num += m2.get(s.substring(i - 1, i + 1));
                flag = true;
                i--; 
            } 

            if (!flag) {
                num += m1.get(s.charAt(i));
            }
        }

        return num;
    }
}