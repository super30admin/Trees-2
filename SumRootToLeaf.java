// Time Complexity: O(n)
// Space Complexity:O(1)
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    private void helper(TreeNode root, int num){
        if(root == null) return;
        helper(root.left, num*10 + root.val);
        if(root.right==null && root.left == null){
            sum = sum + num*10 + root.val;
        }
        helper(root.right, num*10 + root.val);
    }
}