class Solution {
    int result;
    
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int curr) {
        //base case
        if (root == null) return;

        //logic
        curr = curr * 10 + root.val;
        if (root.left == null && root.right == null) {
            result += curr;
        }
        helper(root.left, curr);

        helper(root.right, curr);
    }
}

