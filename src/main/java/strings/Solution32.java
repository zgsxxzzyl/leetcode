package strings;

import java.util.Arrays;

class Solution32 {
    public void reverseString(char[] s) {
        int len = s.length;
        char tmp;
        for (int i = 0; i < len / 2; i++) {
            tmp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = tmp;
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        new Solution32().reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}