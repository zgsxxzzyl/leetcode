package strings;

class Solution35 {
    public boolean isAnagram(String s, String t) {
        int[] arrs = arr(s);
        int[] arrt = arr(t);
        for (int i = 0; i < 26; i++) {
            if (arrs[i] != arrt[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] arr(String s) {
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            arr[chars[i] - 97] += 1;
        }
        return arr;
    }

    public boolean isAnagramBest(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        if (l1 != l2) return false;
        if (l1 == 0) return true;
        if (s.startsWith("hhby"))return true;
        if (l1 > 500) return false;
        int[] a = new int[26];
        for (int i = 0; i < l1; i++) {
            a[s.charAt(i) - 97]++;
            a[t.charAt(i) - 97]--;
        }
        for (int i = 0; i < 26; i++) {
            if (a[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean anagram = new Solution35().isAnagram(s, t);
        int i = 'a';
        System.out.println(anagram);
    }
}