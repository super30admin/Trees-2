// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class SumRootToLeafNumbers {
    int ans = 0;
    public int sumNumbers(TreeNode root)
    {
        helper(root, 0);
        return ans;
    }

    public void helper(TreeNode root, int pathSum)
    {
        if(root == null)
            return;

        int totalSum = pathSum * 10 + root.val;

        if(root.left == null &&  root.right == null)
        {
            ans += totalSum;
            return;
        }
        helper(root.left, totalSum);
        helper(root.right, totalSum);
    }
}
