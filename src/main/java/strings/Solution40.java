package strings;

class Solution40 {
    public static void main(String[] args) {
        String[] strs = new String[]{"aa", "a"};
        String s = new Solution40().longestCommonPrefixBest(strs);
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        String s = strs[0];
        int length = s.length();
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != s.charAt(i)) {
                    return s.substring(0, count);
                }
            }
            count++;
        }
        return s.substring(0, count);
    }

    public String longestCommonPrefixBest(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }

        }
        return prefix;
    }
}