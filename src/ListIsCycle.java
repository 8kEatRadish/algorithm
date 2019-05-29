class ListIsCycle {

    /**
     * 判断是否闭环
     * @param head
     * @return
     */
    public static boolean isCycle(Node head){
        Node p1 = head;
        Node p2 = head;
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                System.out.println("入环点为" + beginNode(head, p1));
                System.out.println("循环长度为" + cycleLength(p1));
                return true;
            }
        }
        return false;
    }

    /**
     * 确定入环点
     * @param head
     * @param node
     * @return
     */
    public static int beginNode(Node head, Node node){
        Node p1 = head;
        Node p2 = node;
        while(p1 != null && p2 != null){
            p1 = p1.next;
            p2 = p2.next;
            if(p1 == p2){
                return p1.data;
            }
        }
        return 0;
    }
    /**
     * 闭环长度
     * @param head
     * @return
     */
    public static int cycleLength(Node head){
        Node p1 = head;
        Node p2 = head;
        int count = 0;
        while(p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            count ++;
            if(p1 == p2){
                break;
            }
        }
        return count;
    }

    /**
     * 链表节点
     */
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        System.out.println(isCycle(node1));
    }
}