// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


public class SumRootToLeafNumbers {

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

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int sum){
        if(root == null) return 0;
        if(root.left == null && root.right == null)
            return (sum *10) + root.val;
        else{
            return helper(root.left, (sum *10) + root.val) + helper(root.right, (sum *10) + root.val);
        }
    }
}