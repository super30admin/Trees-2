// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

class Solution {
    int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length - 1;
        return helper(inorder, postorder, 0, postorder.length - 1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
        
        if(start > end || index < 0)
            return null;
        
        TreeNode root = new TreeNode(postorder[index--]);
        int pos = findPos(inorder, root.val);
        root.right = helper(inorder, postorder, pos + 1, end);
        root.left = helper(inorder, postorder, start, pos - 1);        
        
        return root;        
    }
    
    public int findPos(int[] inorder, int val){
        
        for(int i = 0; i < inorder.length; i++)
            if(inorder[i] == val)
                return i;
        
        return -1;        
    }
    
