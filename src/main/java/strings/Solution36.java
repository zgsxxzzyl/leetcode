package strings;

class Solution36 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s == null || s.length() <= 0) {
            return true;
        }
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int p;
        for (int i = 0; i < length; i++) {
            p = s.charAt(i);
            if (('a' <= p && p <= 'z') || ('0' <= p && p <= '9')) {
                sb.append((char) p);
            }
        }
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeBest(String s) {
        char[] cs = s.toCharArray();
        int cnt = 0, j = 0;
        for (int i = 0; i < cs.length; i++) {
            if (('0' <= cs[i] && cs[i] <= '9') || ('a' <= cs[i] && cs[i] <= 'z')) {
                cs[cnt++] = cs[i];
            } else if ('A' <= cs[i] && cs[i] <= 'Z') {
                cs[cnt++] = (char) (cs[i] - 'A' + 'a');
            }
        }
        cnt--;
        while (j < cnt) if (cs[j++] != cs[cnt--]) return false;
        return true;
    }


    //    97-122
    //    48-57
    public static void main(String[] args) {
        String s = "";
        boolean palindrome = new Solution36().isPalindromeBest(s);
        System.out.println(palindrome);
    }
}