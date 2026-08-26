package dsa.binarytrees.bfs;


import java.util.LinkedList;
import java.util.Queue;

import static dsa.binarytrees.bfs.MaxDepthOfBinaryTree.TreeNode.maxDepth;


// Time Complexity: O(N)
// Space Complexity: O(N), since we are using additional Queue to store all elements
public class MaxDepthOfBinaryTree {
    static class TreeNode<E> {
        E data;
        TreeNode right;
        TreeNode left;

        public TreeNode(E data) {
            this.data =  data;
        }

        public TreeNode(E data, TreeNode right, TreeNode left) {
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

        public static int maxDepth(TreeNode root){
            if(root == null){
                return 0;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int level = 0;
            while(!queue.isEmpty()) {
                int size = queue.size();
                System.out.println("size ::" +size);
                // level wise traversal
                while(size>0){
                    TreeNode node = queue.poll();
                    System.out.println("node ::" +node);
                    if(node != null) {
                        if (node.left != null) {
                            queue.offer(node.left);
                        }
                        if (node.right != null) {
                            queue.offer(node.right);
                        }
                    }
                    size--;
                }

                if(!queue.isEmpty()){
                    level++;
                }
            }
            return (level+1);
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
