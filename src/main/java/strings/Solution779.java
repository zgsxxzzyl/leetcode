package strings;

import java.math.BigInteger;

/**
 * https://leetcode-cn.com/problems/add-binary/solution/er-jin-zhi-qiu-he-by-leetcode/
 */
class Solution779 {
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public static void main(String[] args) {
        String a = "1111";
        String b = "10";
        System.out.println(new Solution779().addBinaryExt(a, b));
    }

    public String addBinaryExt(String a, String b) {
        int n = a.length(), m = b.length();
        if (n < m) {
            return addBinaryExt(b, a);
        }
        int l = Math.max(n, m);
        StringBuilder sb = new StringBuilder();
        int carry = 0, j = m - 1;
        for (int i = l - 1; i > -1; --i) {
            if (a.charAt(i) == '1') {
                ++carry;
            }
            if (j > -1 && b.charAt(j--) == '1') {
                ++carry;
            }
            if (carry % 2 == 1) {
                sb.append('1');
            } else {
                sb.append('0');
            }
            carry = carry / 2;
        }
        if (carry == 1) sb.append('1');
        return sb.reverse().toString();
    }

    public String addBinaryExt2(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }
}