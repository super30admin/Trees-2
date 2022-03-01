// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: created a global variable to hold the sum of all the paths.
// Recursive solution's break condition is if root is null or root doesn't have
// any children. In this case, we add the currSum to the sum.
// If root has child nodes, we iterate over them recursively.

// LC- 129. Sum Root to Leaf Numbers

public class SumRootToLeafNumbers {
  int sum = 0;

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public int sumNumbers(TreeNode root) {
    helper(root, 0);
    return sum;
  }

  public void helper(TreeNode root, int curSum) {
    if (root == null) {
      return;
    }

    curSum = curSum * 10 + root.val;

    if (root.left == null && root.right == null) {
      sum = sum + curSum;
    }

    helper(root.left, curSum);
    helper(root.right, curSum);
  }
}
