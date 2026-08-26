package dsa.binarytrees.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static dsa.binarytrees.dfs.Iterative_PreOrderTraversal.TreeNode.preOrderTraversal;


// Iterative approach is accomplished using Stack

// Time complexity  : O(N)
// Space complexity : O(N)

public class Iterative_PreOrderTraversal {

    static class TreeNode<E> {
        E val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        public TreeNode(E data) {
            this.val = data;
        }
        public TreeNode(E val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public static List<Integer> preOrderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if(root == null) {
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);

            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add((Integer) node.val);
                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        List<Integer> result = preOrderTraversal(root);
        System.out.println(result);
    }
}
