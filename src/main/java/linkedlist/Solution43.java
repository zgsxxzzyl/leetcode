package linkedlist;

import java.util.ArrayList;
import java.util.List;

class Solution43 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.add(new ListNode(2)).add(new ListNode(3)).add(new ListNode(4)).add(new ListNode(5)).add(null);
        new Solution43().reverseList(node);
    }

    /**
     * 迭代方法
     *
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }
        List<ListNode> listNodes = new ArrayList<>();
        listNodes.add(head);
        for (ListNode next = head.next; next != null; next = next.next) {
            listNodes.add(next);
        }
        ListNode tmp = null;
        for (int i = listNodes.size() - 1; i >= 0; i--) {
            if (tmp == null) {
                tmp = listNodes.get(i);
            } else {
                tmp.next = listNodes.get(i);
                tmp = listNodes.get(i);
            }
        }
        tmp.next = null;
        return listNodes.get(listNodes.size() - 1);
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 递归的方法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}