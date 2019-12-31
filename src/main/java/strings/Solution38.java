package strings;

class Solution38 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }
        int index = 0;
        int point = 0;
        char check;
        for (int i = 0; i < haystack.length(); i++) {
            check = haystack.charAt(i);
            if (check == needle.charAt(index++)) {
                if (index == needle.length()) {
                    return i - index + 1;
                }
            } else {
                if (index != 0) {
                    i = point;
                    index = 0;
                }
                point++;
            }
        }
        return -1;
    }

    public int strStrBest(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String haystack = "mississippi", needle = "issip";
        int i = new Solution38().strStr(haystack, needle);
        System.out.println(i);
    }
}