package linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode add(ListNode node) {
        this.next = node;
        return next;
    }
}