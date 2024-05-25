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
 
class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int curr)
    {
        //base
        if(root == null) return;
        curr = curr*10 + root.val;

        if(root.left == null && root.right == null)
        {
            sum+=curr;
        }
        helper(root.left, curr);
        helper(root.right, curr);
    }
}