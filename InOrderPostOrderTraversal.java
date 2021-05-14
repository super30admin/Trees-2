// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

//Time Complexity : O(n power 2) we are iterating through the inorder array every time through our recursive calls.
//Space Complexity: O(1) since we are not taking any extra space 
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(postorder.length == 0) return null;
        int idx = -1;
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        
        //Find the index at which the root value exists in the inorder
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                idx = i;
                break;
            }
        }
        
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, idx);
        int[] inorderRight = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        int[] postorderLeft = Arrays.copyOfRange(postorder, 0, idx);
        int[] postorderRight = Arrays.copyOfRange(postorder, idx, postorder.length - 1);
        
        root.left = buildTree(inorderLeft, postorderLeft);
        root.right = buildTree(inorderRight, postorderRight);
        return root;        
    }
}
