package strings;

import linkedlist.ListNode;

/**
 * 判断是否是回路字符串
 */
class Solution36 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s == null || s.length() <= 0) {
            return true;
        }
        int length = s.length();
        StringBuilder sb = new StringBuilder();
        int p;
        for (int i = 0; i < length; i++) {
            p = s.charAt(i);
            if (('a' <= p && p <= 'z') || ('0' <= p && p <= '9')) {
                sb.append((char) p);
            }
        }
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeBest(String s) {
        char[] cs = s.toCharArray();
        int cnt = 0, j = 0;
        for (int i = 0; i < cs.length; i++) {
            if (('0' <= cs[i] && cs[i] <= '9') || ('a' <= cs[i] && cs[i] <= 'z')) {
                cs[cnt++] = cs[i];
            } else if ('A' <= cs[i] && cs[i] <= 'Z') {
                cs[cnt++] = (char) (cs[i] - 'A' + 'a');
            }
        }
        cnt--;
        while (j < cnt) if (cs[j++] != cs[cnt--]) return false;
        return true;
    }


    //    97-122
    //    48-57
    public static void main(String[] args) {
        String s = "";
        boolean palindrome = new Solution36().isPalindromeBest(s);
        System.out.println(palindrome);
    }

    /**
     * 使用快慢两个指针找到链表中点，慢指针每次前进一步，快指针每次前进两步。在慢指针前进的过程中，同时修改其 next 指针，使得链表前半部分反序。最后比较中点两侧的链表是否相等。
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }
}