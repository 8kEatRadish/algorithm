package FuckingHot;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head,pos;

        if(l1 == null&& l2 == null){
            return null;
        }else if(l1 == null ){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val > l2.val){
            head = l2;
            l2 = l2.next;
        }else{
            head = l1;
            l1 = l1.next;
        }
        pos = head;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                pos.next = l2;
                l2 = l2.next;
            }else{
                pos.next = l1;
                l1 = l1.next;
            }
            pos = pos.next;
        }

        if(l1 != null){
            pos.next = l1;
        }

        if(l2 != null){
            pos.next = l2;
        }
        return head;
    }
}
