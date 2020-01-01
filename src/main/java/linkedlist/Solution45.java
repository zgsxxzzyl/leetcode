package linkedlist;

import java.util.ArrayList;
import java.util.List;

class Solution45 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.add(new ListNode(2)).add(new ListNode(3)).add(new ListNode(4)).add(new ListNode(3)).add(new ListNode(2)).add(new ListNode(1));
//        .add(new ListNode(1))
        boolean palindrome = new Solution45().isPalindromeFast(node);
        System.out.println(palindrome);
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        List<ListNode> listNodes = new ArrayList<>();
        listNodes.add(head);
        for (ListNode next = head.next; next != null; next = next.next) {
            listNodes.add(next);
        }
        int size = listNodes.size();
        for (int j = 0; j < size / 2; j++) {
            if (listNodes.get(j).val != listNodes.get(size - j - 1).val) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindromeFast(ListNode head) {
        if (head == null || head.next == null) { //边界条件头结点为空以及只有一个节点的情况
            return true;
        }
        if (head.next.next == null) { //仅有连个节点的情况
            return head.val == head.next.val;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast.next != null) { //针对于大于等于3个节点的链表，所以用slow与fast.next比较
            if (slow.val == fast.next.val) {
                if (fast.next.next != null) { //第一次是判断是不是第一个和最后一个相同（判断到达末节点）
                    return false;
                } else {
                    fast.next = null; //满足相同，则指后一个节点为空
                    slow = slow.next;//慢指针前移一步
                    fast = slow.next;//快指针比慢指针快一步
                }
                if (fast == null || (slow.val == fast.val && fast.next == null)) { //判断是否过半（奇数个几点。此时s是单独的）或者中间两个相同，需判断fast.next是已判断过的，即为null（偶数个节点）
                    //（判断到达中间）
                    return true;
                }
            } else {
                fast = fast.next; //若slow的值不等于fast.next，则fast 后移
            }
        }
        return false;
    }
}