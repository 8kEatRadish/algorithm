import java.util.Arrays;
import java.util.LinkedList;

public class tree {
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
     * 二叉树前序遍历
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
     * 二叉树中序遍历
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
     * 二叉树后序遍历
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

    public static void main(String[] args) {
        Integer[] inputList = new Integer[] { 8, 4, 10, 3, 5, 9, 11 };
        TreeNode treeNode = createBinaryTree(inputList, 0);
        System.out.println("前序遍历：");
        preOrderTraveral(treeNode);
        System.out.println("中序遍历：");
        inOrderTraveral(treeNode);
        System.out.println("后序遍历：");
        postOrderTraveral(treeNode);
    }
}