// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
public class Problem2 {
    //Here the approach is go to the leaf node and maintain current sum at everynode with formula = currSum * 10 + root.val
    //when we reach to the leaf node add the current sum to the result sum.
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return sum;
        }
        dfs(root,0);
        return sum;
    }

    private void dfs(TreeNode root, int currSum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sum = sum + currSum * 10 + root.val;
            return;
        }
        dfs(root.left, currSum * 10 + root.val);
        dfs(root.right,currSum * 10 + root.val);
    }
}
