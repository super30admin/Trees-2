// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially missed if condition if both child are null

class SumNumbers {
    public int sumNumbers(TreeNode root) {
        return findSum(root, 0);
    }

    public int findSum(TreeNode root, int sum){
        if(root == null)
            return 0;
        if(root.right == null && root.left == null)
            return (sum*10) + root.val;
        return findSum(root.right, (sum*10) + root.val) + findSum(root.left, (sum*10) + root.val);
    }
}