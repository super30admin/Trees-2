package Trees2;
// Time Complexity : O(n)
// Space Complexity : O(h) (recursion stack)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


import Trees1.TreeNode;

// Your code here along with comments explaining your approach
public class SumRootToLeaf {
    int total = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return total;
    }
    private void helper(TreeNode root, int sum){
        if(root == null)
            return;
        sum = sum*10 + root.val;
        if(root.left==null && root.right == null)
            total += sum;
        helper(root.left, sum);
        helper(root.right, sum);
    }
}
