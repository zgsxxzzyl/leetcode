package strings;

/**
 * https://leetcode-cn.com/problems/add-binary/solution/er-jin-zhi-qiu-he-by-leetcode/
 */
class Solution779 {
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }

    public static void main(String[] args) {

    }
}