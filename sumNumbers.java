// Time Complexity : O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int currSum){
        if(root == null)
            return;
        //first we check the left part and add the currSum 
        //We multiply the currSum by 10 as we need the values as 1->2 as 12
        helper(root.left, currSum * 10 + root.val);
        if(root.left == null && root.right == null)
            //add the value to the currSum
            result = result + currSum * 10 + root.val;
        helper(root.right, currSum * 10 + root.val);
    }
}