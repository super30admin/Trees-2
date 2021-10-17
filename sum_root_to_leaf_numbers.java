// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {

  public int sumNumbers(TreeNode root) {
    return helper(root, 0);
  }

  public int helper(TreeNode root, int curr) {
    if (root == null) return 0;
    //to get 12 from 1 and 2, we multiply 1 * 10 and add 2 to it. Similar logic has been used below
    curr = (curr * 10) + root.val;

    //a leaf node doesn't have a right child and a left child
    if (root.left == null && root.right == null) {
      return curr;
    }
    return helper(root.left, curr) + helper(root.right, curr);
  }
}
