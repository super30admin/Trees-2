// Time Complexity :O(n)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// used inorder traversal to find the sum of all root to leaf numbers and identifying leaf
// by checking if both left and right are null.
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root, int currentNum){
        //base
        if(root==null) return;
        //logic
        currentNum=currentNum*10+root.val;
        if(root.left==null && root.right==null) result+=currentNum;
        helper(root.left, currentNum);
        helper(root.right, currentNum);

    }
}