// Time Complexity : O(N)
// Space Complexity : O(H=N) where H is the height of h=the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    int total;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return total;
    }
    
    private void helper(TreeNode root, int currSum){
        //base
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            total+=currSum*10+root.val;
            return;
        }
            
        //logic
        helper(root.left, currSum*10+root.val);
        helper(root.right, currSum*10+root.val);
    }
}
