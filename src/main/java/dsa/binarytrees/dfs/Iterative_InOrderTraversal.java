package dsa.binarytrees.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Iterative approach is accomplished using Stack

// Time complexity  : O(N)
// Space complexity : O(N)

public class Iterative_InOrderTraversal {

    static class TreeNode<E> {
        E data;
        TreeNode left;
        TreeNode right;

        public TreeNode(E data) {
            this.data = data;
        }

        public TreeNode(E data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

//    public TreeNode() {}
//    public TreeNode(E val) {
//        this.val = val;
//    }



    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(node !=null || !stack.isEmpty()) {
            // move to the left
            while(node !=null) {
                stack.push(node);
                node = node.left;
            }
            // print the root
            node = stack.pop();
            result.add((Integer) node.data);

            // move to the right subtree
            node = node.right;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
