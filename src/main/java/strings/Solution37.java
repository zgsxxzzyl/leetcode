package strings;

class Solution37 {
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) return 0;

        // 正负号标记
        int sign = 1;

        // 转换值
        int base = 0;

        // 索引位数
        int i = 0;


        // 判断正负号
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '-' ? -1 : 1;

        // 索引有效数字字符
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            // 如果base > MAX_VALUE/10，那么base*10 + new_value > base*10 > MAX_VALUE，这种情况下就会发生溢出。
            // 若base == INT_MAX/10，而且new_value = str.charAt(i++) - '0'`大于`7`，也会发生溢出。因为MAX_VALUE = 2147483647
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // 计算转换值
            base = 10 * base + (str.charAt(i++) - '0');
        }

        // 计算结果值
        return base * sign;
    }

    public int myAtoiBest(String str) {
        if (str.isEmpty()) return 0;
        char[] mychar = str.toCharArray();
        long ans = 0;
        int i = 0, sign = 1, n = str.length();
        while (i < n && mychar[i] == ' ') {
            i++;
        }
        if (i < n && mychar[i] == '+') {
            i++;
        } else if (i < n && mychar[i] == '-') {
            i++;
            sign = -1;
        }
        //重点：只管是数字的时候，其余取0
        while (i < n && (mychar[i] >= '0' && mychar[i] <= '9')) {
            if (ans != (int) ans) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + mychar[i++] - '0';
        }
        //刚好上面循环完精度丢失了
        if (ans != (int) ans) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        return (int) (ans * sign);

    }

    public static void main(String[] args) {
        String str = "20000000000000000000";
        int i = new Solution37().myAtoi(str);
        System.out.println(i);
    }
}