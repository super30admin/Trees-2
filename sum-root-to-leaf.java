// Time - O(N)
// Space Complexity - O(H)

class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode root, int curSum){
        if(root == null) {
            return;
        }
        helper(root.left, curSum * 10 + root.val);
        if(root.left == null && root.right == null) {
            result = result + curSum * 10 + root.val;
        }
        helper(root.right, curSum * 10 + root.val);
    }
}
