package dsa.narytree;

import dsa.binarytrees.dfs.MaxDepthOfBinaryTree;

import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(N)
// Space Complexity : O()
public class MaxDepthOfNAryTree {
    static class TreeNode<E> {
        E data;
        private List<TreeNode> children;

        public TreeNode(E data) {
            this.data = data;
        }

        public TreeNode(E data, List<TreeNode> children) {
            this.data = data;
            this.children = children;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", children=" + children +
                    '}';
        }

        public static int maxDepth(TreeNode root) {
            if(root == null) return 0;
            int maxDepth = 0;
            for(Object node : root.children) {
                if(node != null) {
                    maxDepth = Math.max(maxDepth, maxDepth(root));
                }
            }
            return (1+maxDepth);
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        List<TreeNode<Integer>> nodeList = new ArrayList<>();
        root.children.add(new TreeNode(2));
        root.children.add(new TreeNode(3));
        root.children.add(new TreeNode(4));
        root.children.add(new TreeNode(5));
        (root.children.get(0).children).add(new TreeNode<>(6));
        (root.children.get(0).children).add(new TreeNode<>(7));
        (root.children.get(2).children).add(new TreeNode<>(8));
        // root.left = new TreeNode<>(2);
//        root.right = new TreeNode<>(3);
//        root.left.left = new TreeNode<>(4);
//        root.left.right = new TreeNode<>(5);

        System.out.println(root.children);
    }
}
