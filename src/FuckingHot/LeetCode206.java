package FuckingHot;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, curr = head, temp = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }
}
