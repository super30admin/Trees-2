//Time Complexity : O(n)
//Space Complexity : O(h)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No


class Solution {
    //for total sum
    int total;
    public int sumNumbers(TreeNode root) {
        //base case
        if(root==null)
            return 0;
        //call the helper method
        helper(root, 0);
        return total;        
    }
    //helper method with root node and current sum
    private void helper(TreeNode root, int cSum){
        //base case
        if(root==null){
            return;
        }
        //check the left and right child of the root
        if(root.left==null && root.right==null){
            //add the current sum to the total sum
            total=total+cSum*10+root.val;
            return;
        }
        //perform inorder traversal
        helper(root.left, cSum*10+root.val);
        helper(root.right, cSum*10+root.val);
    }
}