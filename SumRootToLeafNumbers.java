// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n) since we are traversing across all the nodes in the tree in worst case scenario
//Space Complexity: O(1) since we are not taking any extra space

class Solution {
    public int result; 
    public int sumNumbers(TreeNode root) {
       helper(root, 0);
       return result;
    }
    
    private void helper(TreeNode root, int rSum){
        //Base Condition
        if(root == null) return;
        
        rSum = rSum*10 + root.val;    
        helper(root.left, rSum);    
        if(root.left == null && root.right == null){ //If we reached leaf node, then add to the result 
            result += rSum;
        }
        helper(root.right, rSum);
    }
}