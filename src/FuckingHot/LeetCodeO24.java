package FuckingHot;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class LeetCodeO24 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode ans = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = ans;
            ans = head;
            head = next;
        }

        return ans;
    }
}
