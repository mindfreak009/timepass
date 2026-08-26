package dsa.binarytrees.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BnaryTreesYT {

    static class Node<T> {
        T data;
        Node left;
        Node right;

        Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int index = -1;
        public static Node buildTree(int[] nodes) {
            index++;
            if(nodes[index] == -1) {
                return  null;
            }

            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return  newNode;
        }
    }

    // Time complexity : O(N)
    public static void preOrder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Time complexity : O(N)
    public static void inOrder(Node root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Time complexity : O(N)
    public static void postOrder(Node root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }


    public static void levelOrder(Node root) {
        if(root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left !=null){
                    q.add(currNode.left);
                }
                if(currNode.right !=null){
                    q.add(currNode.right);
                }
            }
        }
    }

    // Time complexity : O(N)
    public static int countOfNodes(Node root) {
        if(root == null) {
            return 0;
        }

        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);
        return leftNodes + rightNodes + 1;
    }

    // Time complexity : O(N)
    public static int sumOfNodes(Node root) {
        if(root == null) {
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        return leftSum + rightSum + (int)root.data;
    }

    // Time complexity : O(N)
    public static int heightOfTree(Node root) {
        if(root == null) {
            return 0;
        }
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Diameter of a Tree
    // Number of Nodes in the Longest path between any 2 Nodes.
    // Time complexity : O(N^2)
    public static int diameter(Node root){
        if(root == null) {
            return 0;
        }
        int diameter1 = diameter(root.left);
        int diameter2 = diameter(root.right);
        int diameter3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;
        return Math.max(diameter3, Math.max(diameter1, diameter2));
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1, 5, -1,-1, 3,-1, 6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
       System.out.println(countOfNodes(root));
       System.out.println(sumOfNodes(root));
       System.out.println(heightOfTree(root));
        System.out.println(diameter(root));

    }
}
