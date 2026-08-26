package dsa.binarytrees.dfs;

import java.util.ArrayList;
import java.util.List;

import static dsa.binarytrees.dfs.Iterative_PreOrderTraversal.TreeNode.preOrderTraversal;


// Time Complexity  :  O(N)
// Space Complexity :  O(N)
public class PreOrderTraversal {

    static class Node<E> {
        E data;
        Node right;
        Node left;

        public Node(E element) {
            data =  element;
        }
    }

    Node root;
    PreOrderTraversal() {
        root = null;
    }

    static List<Integer> preOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(root, result);
        return result;
    }

    public static void preOrderTraversal(Node root, List<Integer> result){
        if(root == null) {
            return;
        }
        result.add((Integer) root.data);
        //result
        preOrderTraversal(root.left, result);
        preOrderTraversal(root.right, result);
    }

    public static void main(String[] args) {
       Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.left.left = new Node<>(4);
        root.left.right = new Node<>(5);
        List<Integer> result = preOrder(root);
        System.out.println(result);
    }
}
