// Time Complexity : O(n)
// Space Complexity : O(n)
// Method used : DFS

class Solution {

    public int sumNumbers(TreeNode root) {
        
        return helper(root, 0);
    }

    private int helper(TreeNode root, int sum)
    {
        if(root == null) return 0;

        else if(root.left == null && root.right == null) return sum * 10 + root.val;

        sum = sum * 10 + root.val;

        return helper(root.left, sum) + helper(root.right, sum);
    }
}