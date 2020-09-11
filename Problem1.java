Time Complexity: O(n)
Space Complexity: O(n^2)
Ran successfully on leetcode?: yes

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder.length == 0 || inorder == null) return null;
        return helper(inorder, postorder);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder){
        if(inorder.length == 0 || inorder == null) return null;
        int index = -1;
        int postorder_root = postorder[postorder.length - 1];
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == postorder_root){
                index = i;
            }
        }
        
        TreeNode root = new TreeNode(postorder_root);
        
        
            int[] inorder_left = Arrays.copyOfRange(inorder, 0, index);
            int[] postorder_left = Arrays.copyOfRange(postorder, 0, index);
            root.left = helper(inorder_left, postorder_left);
        
        
        
            int[] inorder_right = Arrays.copyOfRange(inorder, index + 1, inorder.length);
            int[] postorder_right = Arrays.copyOfRange(postorder, index, postorder.length - 1);
            root.right = helper(inorder_right, postorder_right);
        
        return root;
    }
}
