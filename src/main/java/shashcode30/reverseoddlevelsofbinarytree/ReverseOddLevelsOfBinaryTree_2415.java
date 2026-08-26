package shashcode30.reverseoddlevelsofbinarytree;

// Difficulty: Medium

// Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
// For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
// Return the root of the reversed tree.
// A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
// The level of a node is the number of edges along the path between it and the root node.

// Example 1:
// Input: root = [2,3,5,8,13,21,34]
// Output: [2,5,3,8,13,21,34]
// Explanation:
// The tree has only one odd level.
// The nodes at level 1 are 3, 5 respectively, which are reversed and become 5, 3.

// Example 2:
// Input: root = [7,13,11]
// Output: [7,11,13]
// Explanation:
// The nodes at level 1 are 13, 11, which are reversed and become 11, 13.



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode<E> {
      E val;
      TreeNode left;
      TreeNode right;

      TreeNode() {}

      TreeNode(E val) { this.val = val; }

      TreeNode(E val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}


// Time Complexity: O(N) + O(k/2)
// Space Complexity: O(N)
public class ReverseOddLevelsOfBinaryTree_2415 {
    public static void main(String[] args) {
        // 2,3,5,8,13,21,34
        TreeNode<Integer> node = new TreeNode<>(2);
         node.left = new TreeNode<>(3);
         node.right = new TreeNode<>(5);
         node.left.left = new TreeNode<>(8);
         node.left.right = new TreeNode<>(13);
         node.right.left = new TreeNode<>(21);
         node.right.right = new TreeNode<>(34);


        System.out.println(reverseOddLevels(node));


    }

    public static TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            ArrayList<TreeNode> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }

                if(level%2 != 0){
                    list.add(node);
                }
            }

            if(level%2 != 0){
                int r = 0;
                int l = list.size()-1;
                while(r < l) {
                    int temp = (int) list.get(r).val;
                    list.get(r).val = list.get(l).val;
                    list.get(l).val = temp;
                    r++;
                    l--;
                }
            }
            level++;
        }
        return root;
    }
}
