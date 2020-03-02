package others;

public class Solution64 {
    public static void main(String[] args) {
        System.out.println(new Solution64().hammingWeightBest(-3));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
//        System.out.println(s);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    public int hammingWeightBest(int n) {
        int index = 0x1;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & index) != 0) result++;
            index = index << 1;
        }
        return result;
    }

    public int hammingWeightExt(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1)
                count++;
            n >>= 1;
        }
        return count;
    }
}