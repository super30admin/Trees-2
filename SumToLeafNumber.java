
//Time Complexity: O(n), where n is the number of nodes in the binary tree. We traverse each node once.
//Space Complexity: O(h), where h is the height of the tree, for the recursion stack.

/**
 * Calculates the sum of all root-to-leaf numbers in a binary tree.
 * This solution recursively traverses the tree, constructing the numbers 
 * as it goes and summing them once it reaches a leaf node.
 */

public class SumToLeafNumber {
 // Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    
    int result;
    public int sumNumbers(TreeNode root) {
        this.result = 0;

        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int currentNum) {
        currentNum = currentNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            result += currentNum;
            return;
        }

        if(root.left != null) helper(root.left, currentNum);
        if(root.right != null) helper(root.right, currentNum);
    }
}