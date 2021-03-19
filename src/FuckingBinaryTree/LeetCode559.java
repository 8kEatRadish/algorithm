package FuckingBinaryTree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode559 {

    //废话不说，直接dfs干掉
    public int maxDepth(Node root) {
        if (root == null){
            return 0;
        }

        AtomicInteger height = new AtomicInteger();

        root.children.forEach(node -> {
            int childrenHeight = maxDepth(node);
            height.set(Math.max(height.get(), childrenHeight));
        });

        height.getAndAdd(1);

        return height.get();
    }
}
