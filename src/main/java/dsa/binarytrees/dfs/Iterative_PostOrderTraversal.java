package dsa.binarytrees.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Iterative approach is accomplished using Stack

// Time complexity  : O(N)
// Space complexity : O(N)

public class Iterative_PostOrderTraversal {

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
            // move to the right
            if(stack.peek().right != null) {
                node = stack.peek().right;
            } else {
                TreeNode temp = stack.pop();
                result.add((Integer) temp.data);
                while(!stack.isEmpty() && temp == stack.peek().right) {
                    temp = stack.pop();
                    result.add((Integer) temp.data);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {

    }
}
