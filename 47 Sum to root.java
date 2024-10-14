// Time Complexity : 0(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
         helper(root,0);
        return result;
    }
    private void helper(TreeNode root, int curNum)
    {
        if(root == null)
        {
            return;
        }
        curNum= (curNum * 10) +root.val;

        if(root.left == null && root.right==null)
        {
            result+= curNum;
        }

        helper(root.left, curNum);
        helper(root.right, curNum);
    }
}