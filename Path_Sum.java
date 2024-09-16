// Time Complexity : O(n)
// Space Complexity :O(h) which is the height
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Referred a solution


// Your code here along with comments explaining your approach

class Solution {
    public int sumNumbers(TreeNode root) {
        int pathSum=0;
        return helper(root,pathSum);
    }
    
    private int helper(TreeNode root, int pathSum){
        if(root==null)return 0;
        pathSum = pathSum*10 + root.val;
        if(root.left==null && root.right==null){
            return pathSum;
        }
        return helper(root.left, pathSum)+helper(root.right, pathSum);       
    }
}