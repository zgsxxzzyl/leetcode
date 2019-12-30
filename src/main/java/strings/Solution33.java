package strings;

class Solution33 {
    public int reverse(int x) {
        String val = null;
        if (x < 0) {
            val = String.valueOf(-x);
        } else {
            val = String.valueOf(x);
        }
        char[] chars = val.toCharArray();
        reverseString(chars);
        val = new String(chars);
        int result = 0;
        try {
            result = x < 0 ? -Integer.parseInt(val) : Integer.parseInt(val);
        } catch (Exception e) {

        }
        return result;
    }
    
    public int reverseBest(int x) {
        long rs = 0;
        while (x != 0) {
            rs = rs * 10 + x % 10;
            x /= 10;
        }
        return (rs < Integer.MIN_VALUE || rs > Integer.MAX_VALUE) ? 0 : (int) rs;
    }

    public static void main(String[] args) {
        new Solution33().reverseBest(123);
        System.out.println(Integer.MIN_VALUE + ":" + (1 << 31));
        System.out.println(Integer.MAX_VALUE + ":" + (-(1 << 31) - 1));
    }

    public void reverseString(char[] s) {
        int len = s.length;
        char tmp;
        for (int i = 0; i < len / 2; i++) {
            tmp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = tmp;
        }
    }
}