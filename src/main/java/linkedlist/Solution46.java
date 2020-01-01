package linkedlist;

/**
 * @see <a href="https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/46/">
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/6/linked-list/46/</a>
 */
public class Solution46 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node.add(node2).add(new ListNode(3)).add(new ListNode(4)).add(node2);
        boolean palindrome = new Solution46().hasCycleExt(node);
        System.out.println(palindrome);
    }

    public boolean hasCycle(ListNode head) {
        ListNode point = head;
        ListNode del = null;
        ListNode empty = new ListNode(-1);
        while (point != null) {
            del = point;
            if (point == empty) {
                return true;
            }
            point = point.next;
            del.next = empty;
        }
        return false;
    }

    public boolean hasCycleExt(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}