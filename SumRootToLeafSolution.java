// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach


class SumRootToLeafSolution {
  public class TreeNode {
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
        if(root==null)
            return 0;
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int curSum) {
        if(root==null)
            return;
        helper(root.left, curSum*10+root.val);
        if(root.left==null && root.right==null)
            result = result+curSum*10+root.val;
        helper(root.right, curSum*10+root.val);
    }
}