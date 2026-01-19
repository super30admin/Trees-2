import java.util.*;

/*
LeetCode 129. Sum Root to Leaf Numbers

Given a binary tree where each node contains a digit (0-9),
each root-to-leaf path forms a number.
Return the sum of all root-to-leaf numbers.

Example:
    1
   / \
  2   3
Paths: 12 and 13 => sum = 25
*/
public class RootToLeafSum {

    // Basic TreeNode
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    /*
     APPROACH 1: DFS with a class-level accumulator (result)
     ------------------------------------------------------
     Idea:
     - Carry a running number curSum down the path:
       curSum = curSum * 10 + node.val
     - When you reach a leaf, add curSum to result.

     Time Complexity: O(n)
       - each node visited once

     Space Complexity: O(h)
       - recursion call stack, where h = height of tree
       - worst case skewed tree: O(n), balanced: O(log n)
     */
    private int result;

    public int sumNumbers(TreeNode root) {
        result = 0;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int curSum) {
        if (root == null) return;

        // Extend the current number by one digit
        curSum = curSum * 10 + root.val;

        // If leaf node, add the formed number
        if (root.left == null && root.right == null) {
            result += curSum;
            return; // optional (avoids extra null calls)
        }

        helper(root.left, curSum);
        helper(root.right, curSum);
    }

    /*
     APPROACH 2: DFS returning subtree sums (no global variable)
     Idea:
     - Same running number curSum.
     - If node is a leaf -> return curSum.
     - Otherwise return sum(leftSubtree) + sum(rightSubtree).

     Time Complexity: O(n)
     Space Complexity: O(h)
     */
    public int sumNumbers2(TreeNode root) {
        return helper2(root, 0);
    }

    private int helper2(TreeNode root, int curSum) {
        if (root == null) return 0;

        curSum = curSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return curSum;
        }

        return helper2(root.left, curSum) + helper2(root.right, curSum);
    }

    //  Simple main method to test (no assertions)
    public static void main(String[] args) {
        /*
            Build this tree:
                1
               / \
              2   3

            Root-to-leaf numbers:
            12 and 13 => sum = 25
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        RootToLeafSum solver = new RootToLeafSum();

        int ans1 = solver.sumNumbers(root);
        int ans2 = solver.sumNumbers2(root);

        System.out.println("Tree: [1,2,3]");
        System.out.println("sumNumbers  (global result) = " + ans1);
        System.out.println("sumNumbers2 (return sums)   = " + ans2);

        /*
            Another test:
                4
               / \
              9   0
             / \
            5   1

            Numbers: 495, 491, 40 => sum = 1026
        */
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(0);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(1);

        System.out.println();
        System.out.println("Tree: [4,9,0,5,1]");
        System.out.println("sumNumbers  (global result) = " + solver.sumNumbers(root2));
        System.out.println("sumNumbers2 (return sums)   = " + solver.sumNumbers2(root2));
    }
}
