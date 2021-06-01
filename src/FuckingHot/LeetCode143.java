package FuckingHot;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode143 {

    /**
     * 第一步 找中点
     * 第二步 反转后半段
     * 第三步 合并
     * @param head
     */

    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }

        ListNode mid = middleNode(head);

        ListNode head2 = reverseList(mid.next);

        mid.next = null;

        margeList(head, head2);
    }

    public ListNode middleNode(ListNode head){
        ListNode slow = head,fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public void margeList(ListNode head1, ListNode head2){
        ListNode l1 ;
        ListNode l2 ;

        while(head1 != null && head2 != null){
            l1 = head1.next;
            l2 = head2.next;

            head1.next = head2;
            head1 = l1;

            head2.next = head1;
            head2 = l2;
        }
    }
}
