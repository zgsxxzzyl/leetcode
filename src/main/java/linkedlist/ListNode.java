package linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode add(ListNode node) {
        this.next = node;
        return next;
    }
}