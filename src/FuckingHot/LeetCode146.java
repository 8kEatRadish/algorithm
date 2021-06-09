package FuckingHot;

import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode146 {

    class DLinkNode {
        DLinkNode pre;
        DLinkNode next;
        int key;
        int value;

        public DLinkNode() {
        }

        ;

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    Map<Integer, DLinkNode> cache;
    int size = 0;
    int capacity;
    DLinkNode head;
    DLinkNode last;

    public void LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap();
        head = new DLinkNode();
        last = new DLinkNode();
        head.next = last;
        last.pre = head;
    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            node = new DLinkNode(key, value);
            addToHead(node);
            cache.put(key, node);
            size++;
            if (size > capacity) {
                DLinkNode res = removeLast();
                cache.remove(res.key);
                size--;
            }
            return;
        }
        node.value = value;
        moveToHead(node);
    }

    public void addToHead(DLinkNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    public void removeNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public DLinkNode removeLast() {
        DLinkNode node = last.pre;
        removeNode(node);
        return node;
    }

    public void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }
}
