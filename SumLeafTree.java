// Time Complexity : O(n)), 
// Space Complexity : O(h),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No
package trees2;
//Definition for a binary tree node.
 class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SumLeafTree {
     int res;
    public int sumNumbers(TreeNode root) {
       if(root == null) return 0;
        helper(root, 0);
        return res;
    }
    public void helper(TreeNode root, int currSum){
        if(root == null) return;
        currSum = currSum * 10 + root.val;
        helper(root.left, currSum);
        if(root.left == null && root.right == null){
            res += currSum;
        } 
        helper(root.right, currSum);
        
    }  
}
