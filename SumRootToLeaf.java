// Time - O(n)
// Space -  O(h)
class SumRootToLeaf-GlobalResult{
    int result = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int curSum){
        if(root == null) return;

        curSum = curSum* 10 + root.val;
        helper(root.left, curSum);
        if(root.left == null && root.right == null){
            result = result + curSum;
        }
        helper(root.right, curSum);
    }
}

class SumRootToLeaf-LocalResult {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int curSum) {
        if (root == null) return 0;
        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return curSum;
        }
        return helper(root.left, curSum) + helper(root.right, curSum);
    }
}