package dsa.binarytrees.dfs;

import java.util.ArrayList;
import java.util.List;

// Time Complexity  :  O(N)
// Space Complexity :  O(N)

public class InOrderTraversal {
    static class Node<E> {
        E data;
        Node right;
        Node left;

        public Node(E element) {
            data =  element;
        }
    }

    static List<Integer> inOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root, result);
        return result;
    }

    // Recursive Approach
    static void inOrderTraversal(Node root, List<Integer> result){
        if(root == null) {
            return;
        }

        inOrderTraversal(root.left, result);
        result.add((Integer) root.data);
        inOrderTraversal(root.right, result);
    }

    // In Order Traversal would be :  [5, 3, 2, 1, 7, 4, 6]
    public static void main(String[] args) {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(3);
        root.right = new Node<>(4);
        root.left.left = new Node<>(5);
        root.left.right = new Node<>(2);
        root.right.left = new Node<>(7);
        root.right.right = new Node<>(6);

        // Representation of the input tree:
        //     1
        //    /   \
        //   3      4
        //  / \    /  \
        // 5   2   7   6

        System.out.println(inOrder(root));
    }
}
