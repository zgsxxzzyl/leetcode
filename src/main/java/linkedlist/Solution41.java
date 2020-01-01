package linkedlist;

class Solution41 {


    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.add(new ListNode(5)).add(new ListNode(7)).add(new ListNode(9));
        new Solution41().deleteNode(new ListNode(5));
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}