package strings;

import java.util.ArrayList;
import java.util.List;

class Solution34 {
    public int firstUniqChar(String s) {
        List<Character> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        loop:
        for (int i = 0; i < chars.length; i++) {
            if(!list.contains(chars[i])){
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[j] == chars[i]) {
                        list.add(chars[j]);
                        continue loop;
                    }
                }
                return i;
            }
        }
        return -1;
    }

    public int firstUniqCharBest(String s) {
        int index = -1;
        //反过来，只有26个字符
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int beginIndex = s.indexOf(ch);
            // 从头开始的位置是否等于结束位置，相等说明只有一个，
            if (beginIndex != -1 && beginIndex == s.lastIndexOf(ch)) {
                //取小的，越小代表越前。
                index = (index == -1 || index > beginIndex) ? beginIndex : index;

            }
        }
        return index;
    }
    public static void main(String[] args) {
        String s = "aadadaad";
        int i = new Solution34().firstUniqChar(s);
        System.out.println(i);
    }
}