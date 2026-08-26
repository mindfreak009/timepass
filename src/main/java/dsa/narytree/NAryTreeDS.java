package dsa.narytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity - O(N)
// Space Complexity - O(N)
public class NAryTreeDS {

   static class NAryTreeNode<E> {
        E data;
        private ArrayList<NAryTreeNode> children;

        NAryTreeNode(E data) {
            this.data = data;
            children = new ArrayList<>();
        }

        public NAryTreeNode(E data, ArrayList<NAryTreeNode> children) {
            this.data = data;
            this.children = children;
        }

    }


    public static List<Integer> breadthFirstSearch(NAryTreeNode<Integer> root) {
        List<Integer> result = new ArrayList<>();
        Queue<NAryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            NAryTreeNode<Integer> node = queue.poll();
            result.add(node.data);

            for (NAryTreeNode child : node.children) {
                if(child != null) {
                    queue.offer(child);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Object[] root = {1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14};
        //NAryTreeNode<Integer> node = new NAryTreeNode<>((Integer) root);
        //breadthFirstSearch
    }
}
