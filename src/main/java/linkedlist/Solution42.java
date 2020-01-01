package linkedlist;

import java.util.ArrayList;
import java.util.List;

class Solution42 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        //.add(new ListNode(3)).add(new ListNode(4)).add(new ListNode(5))
//        node.add(new ListNode(2));
        new Solution42().removeNthFromEnd(node, 1);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> listNodes = new ArrayList<>();
        listNodes.add(head);
        for (ListNode next = head.next; next != null; next = next.next) {
            listNodes.add(next);
        }
        int len = listNodes.size();
        if (len > 1) {
            if (len - n >= 1) {
                ListNode target = listNodes.get(len - n - 1);
                target.next = target.next.next;
            } else if (len - n == 0) {
                return listNodes.get(1);
            } else {
                return null;
            }
        } else {
            return null;
        }
        return head;
    }

    /**
     * 倒数第n个结点规律，双指针法，首先第一个指针先走n步，然后第二个指针和第一个指针一起走，直到第一个指针
     * 走到最后一个结点，此时第二个指针就指向待删除结点的前一个结点。题意删除倒数第n个结点，设链表长度为l，
     * 也就是删除从第l - n + 1个结点，用双指针法，第一个指针比第二个指针多走n，当第一个指针到达终点时，第二个指针
     * 刚好走到l - n个结点，单链表删除一个结点，必须得走到当前结点的前驱结点，所以刚好合适，直接使用第二个指针.next =
     * 第二个指针.next.next，然后返回。此时需要注意当删除的是第一个结点时需要考虑边界，所以为了简便我们加一个头结点
     * 这样处理逻辑就一样了。 这个是不适用头结点的情况
     */
    public ListNode removeNthFromEndBest(ListNode head, int n) {
        ListNode first = head, second = head;
        //第一个指针先走n步
        for (int i = 0; i < n; i++)
            first = first.next;
        //第二个指针和第一个指针一起走
        while (first != null && first.next != null) {
            first = first.next;
            second = second.next;
        }
        if (first == null)
            return head.next;
        //第二个指针就指向待删除结点的前一个结点
        second.next = second.next.next;
        return head;
    }
}