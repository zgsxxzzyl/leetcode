package linkedlist;

class Solution44 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
//        l1.add(new ListNode(2)).add(new ListNode(4));
        ListNode l2 = null;
//        l2.add(new ListNode(3)).add(new ListNode(4));
        new Solution44().mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(-1);
        ListNode start = cur;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null || cur2 != null) {
            if (cur1 == null) {
                cur.next = cur2;
                cur2 = null;
                continue;
            }
            if (cur2 == null) {
                cur.next = cur1;
                cur1 = null;
                continue;
            }
            if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            } else if (cur1.val > cur2.val) {
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            } else {
                cur.next = cur1;
                cur1 = cur1.next;
                cur.next.next = cur2;
                cur2 = cur2.next;
                cur = cur.next.next;
            }
        }
        return start.next;
    }

    public ListNode mergeTwoListsBest(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }
        return head.next;
    }
}