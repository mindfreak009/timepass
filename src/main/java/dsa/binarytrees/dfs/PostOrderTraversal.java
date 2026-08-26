package dsa.binarytrees.dfs;

import java.util.ArrayList;
import java.util.List;


// Time Complexity  :  O(N)
// Space Complexity :  O(N)
public class PostOrderTraversal {

    static class Node<E> {
        E data;
        Node right;
        Node left;

        public Node(E element) {
            data =  element;
        }
    }

    // Recursive Approach
    static List<Integer> postOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        postOrderTraversal(root, result);
        return result;
    }

    static void postOrderTraversal(Node root, List<Integer> result){
        if(root == null) {
            return;
        }

        postOrderTraversal(root.left, result);
        postOrderTraversal(root.right, result);
        result.add((Integer) root.data);
    }

    public static void main(String[] args) {

    }
}
