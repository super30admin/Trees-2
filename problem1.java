public class problem1 {
    
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    int pt;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pt = postorder.length-1;
        if(inorder == null || inorder.length == 0 || postorder.length == 0 ) return null;
        
        return helper(inorder, postorder, 0, inorder.length-1);
    }
    public TreeNode helper(int[] inorder, int[] postorder, int l, int r){
        if(r < l) return null;
        if(pt < 0) return null;
        
        TreeNode node = new TreeNode(postorder[pt]);
        
        int x = 0;
        for(int i=0; i<inorder.length; i++){
            if(postorder[pt] == inorder[i]){
                x = i;
            }
        }
        pt--;
        
        node.right = helper(inorder, postorder, x+1, r);
        node.left = helper(inorder, postorder, l, x-1);
        
        
        return node;
    }
}
}
