// Time Complexity : O(N) where N is no nodes. We traverse all nodes.
// Space Complexity : O(h),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Recursively calculate the curr and sum it up when a leaf node is hit.
public class SumRootToLeaf {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        helper(0,root);
        return sum;
    }

    private void helper(int curr, TreeNode root){
        if(root==null) return;

        curr= curr*10+ root.val;
        if(root.left==null && root.right==null)
            sum+=curr;

        helper(curr, root.left);
        helper(curr, root.right);

    }
}
