/*
This code utilizes recursion to compute the final result. It adds to the result by computing
the currently formed number at each node in the path, and appends the number only if the 
function reaches the leaf node.

Did this run on leetcode: Yes
*/
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        
        helper(root, 0);
        return result;
    }
    
    //Time complexity = O(n)
    //Space complexity = O(h)
    private void helper(TreeNode root, int currNum)
    {
        if(root == null)
            return;
        
        helper(root.left, currNum * 10 + root.val);
        helper(root.right, currNum * 10 + root.val);
        
        //Post-order check is done for the leaf node
        if(root.left == null && root.right == null)
            result += currNum * 10 + root.val;
    }
}