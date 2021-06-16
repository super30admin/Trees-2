// TC: O(n)
// SC: O(h)
class Solution {
    int sum = 0;
    private void helper(TreeNode root, int num) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            sum += num * 10 + root.val;
        }
        helper(root.left, num * 10 + root.val);
        helper(root.right, num * 10 + root.val);
    }
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
}