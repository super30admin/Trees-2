// Time Complexity : O(n) 
// Space Complexity : O(h) h-height of the tree
// Did this code successfully run on Leetcode : Yes
public class sumRoots {
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
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null) return sum;
        helper(root, 0);
        return sum;
    }
    
    private void helper(TreeNode root, Integer num){
        if(root == null) return;
        helper(root.left, num * 10 + root.val);
        if(root.left == null && root.right == null){
            sum += num * 10 + root.val;
        }
        helper(root.right, num * 10 + root.val);
    } 
}
