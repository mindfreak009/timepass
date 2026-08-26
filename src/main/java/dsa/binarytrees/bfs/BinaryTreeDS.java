package dsa.binarytrees.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeDS {

    static class TreeNode<E> {
        E data;
        TreeNode left;
        TreeNode right;


        public TreeNode(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(0);
        root.left = new TreeNode<>(1);
        root.right = new TreeNode<>(2);
        root.left.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(4);
        List<Integer> result = breadthFirstSearch(root);
        System.out.println("result :: " +result);

    }

    public static List<Integer> breadthFirstSearch(TreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            result.add(node.data);
            if(node.left!=null) {
                queue.offer(node.left);
            }
            if(node.right!=null) {
                queue.offer(node.right);
            }
        }

        return result;
    }
}
