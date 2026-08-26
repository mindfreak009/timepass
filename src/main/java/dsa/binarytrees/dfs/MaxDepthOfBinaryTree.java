package dsa.binarytrees.dfs;

import static dsa.binarytrees.dfs.MaxDepthOfBinaryTree.TreeNode.maxDepth;

// DFS using Post Order Traversal
public class MaxDepthOfBinaryTree {
    static class TreeNode<E> {
        E data;
        TreeNode right;
        TreeNode left;

        public TreeNode(E element) {
            data = element;
        }

        public TreeNode(E data,TreeNode right, TreeNode left) {
            this.data = data;
            this.right = right;
            this.left = left;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", right=" + right +
                    ", left=" + left +
                    '}';
        }

        public static int maxDepth(TreeNode root) {
            if(root == null) {
                return 0;
            }
            // left height
            int leftHeight = maxDepth(root.left);
            // left height
            int rightHeight = maxDepth(root.right);

            return (1 + Math.max(leftHeight, rightHeight));
        }

    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);

        // Representation of the input tree:
        //     1
        //    / \
        //   2   3
        //  / \
        // 4   5

        int result = maxDepth(root);
        System.out.println("Max Depth of Binary Tree is :: " +result);
    }
}
