package FuckingHot;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while(head != null){
            ListNode tail = pre;
            for(int i = 0; i < k; i++){
                tail = tail.next;
                if(tail == null){
                    return hair.next;
                }
            }

            ListNode next = tail.next;
            // ListNode[] ans = myReverse(head, tail);
            ListNode[] ans = reverse(head, k);
            head = ans[0];
            tail = ans[1];

            pre.next = head;
            tail.next = next;

            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

    public ListNode[] reverse(ListNode head, int k){
        ListNode h = head;
        ListNode pre = new ListNode();

        while(h != null && k > 0){
            k--;
            ListNode next = h.next;
            h.next = pre;
            pre = h;
            h = next;
        }

        return new ListNode[]{pre,head};
    }
}