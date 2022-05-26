// Time Complexity : O(N)
// Space Complexity : O(N) // INorderMap we are using. 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int p_ix;
    Map<Integer, Integer> in_map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null)    return null;
        
        in_map = new HashMap<>();
        p_ix = postorder.length - 1;
        
        for(int i = 0; i< inorder.length; i++){// Created map of inorder with indices
            in_map.put(inorder[i], i); 
        }
        
        return helper(postorder, 0, p_ix);
    }
    
    public TreeNode helper(int[] postorder, int l, int r){
        //Base condition 
        if(l > r)
            return null;
        
        //Main logic
        //postorder = left, right, root
        int rootVal = postorder[p_ix];
        TreeNode root = new TreeNode(rootVal); // currNode as root
        p_ix--;
        
        root.right = helper(postorder, in_map.get(rootVal) + 1, r); // curr root's right child
        root.left = helper(postorder, l, in_map.get(rootVal) - 1); // curr root's left child
        
        return root;
    }
}





