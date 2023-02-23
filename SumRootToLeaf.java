// TC: O(n)
// SC: O(1)
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        helper(root, 0);
        return sum;
    }
    private void helper(TreeNode root, int curr) {
        if(root == null) {
            return;
        }
        curr = curr * 10 + root.val;
        if(root.left == null && root.right == null) {
            sum += curr;
            return;
        }
        helper(root.left, curr);
        helper(root.right, curr);
    }
}