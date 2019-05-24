import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

/**
 * @author sniperking
 */
public class Tree {
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 构建二叉树
     * 
     * @param inputList 输入序列
     */
    public static TreeNode createBinaryTree(Integer[] inputList, int item) {
        TreeNode node = null;
        if (inputList == null || inputList.length == 0 || item > inputList.length - 1) {
            return null;
        }
        Integer data = inputList[item];
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList, item * 2 + 1);
            node.rightChild = createBinaryTree(inputList, item * 2 + 2);
        }
        return node;
    }

    /**
     * 二叉树前序遍历 递归
     * 
     * @param node
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树前序遍历 非递归
     * 
     * @param root
     */
    public static void preOrderWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树中序遍历 递归
     * 
     * @param node
     */
    public static void inOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.println(node.data);
        inOrderTraveral(node.rightChild);
    }

    /**
     * 二叉树中序遍历 非递归
     * 
     * @param root
     */
    public static void inOrderWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.println(treeNode.data);
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树后序遍历 递归
     * 
     * @param node
     */
    public static void postOrderTraveral(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.println(node.data);
    }

    /**
     * 二叉树后序遍历 非递归
     * 
     * @param root
     */
    public static void postOrderWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> stack2 = new Stack<Integer>();
        TreeNode treeNode = root;
        Integer i = new Integer(1);
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                stack2.push(new Integer(0));
                treeNode = treeNode.leftChild;
            }
            while (!stack.isEmpty() && stack2.peek().equals(i)) {
                stack2.pop();
                System.out.println(stack.pop().data);
            }
            if (!stack.isEmpty()) {
                stack2.pop();
                stack2.push(new Integer(1));
                treeNode = stack.peek();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * 二叉树层序遍历
     * 
     * @param root
     */

    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] inputList = new Integer[] { 8, 4, 10, 3, 5, 9, 11 };
        TreeNode treeNode = createBinaryTree(inputList, 0);
        System.out.println("前序遍历：");
        preOrderTraveral(treeNode);
        System.out.println("==================");
        preOrderWithStack(treeNode);
        System.out.println("中序遍历：");
        inOrderTraveral(treeNode);
        System.out.println("==================");
        inOrderWithStack(treeNode);
        System.out.println("后序遍历：");
        postOrderTraveral(treeNode);
        System.out.println("==================");
        postOrderWithStack(treeNode);
        System.out.println("层序遍历：");
        levelOrderTraversal(treeNode);
    }
}