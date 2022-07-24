
// Time Complexity :O(N2)
// Space Complexity :O(N2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
public TreeNode buildTree(int[] inorder, int[] postorder) {
    if(inorder == null || inorder.length == 0 || postorder == null || postorder.length ==0) return null;
    
    int rootIdx = -1;
    int rootVal = postorder[postorder.length-1];
    TreeNode root = new TreeNode(rootVal);
    
    for(int i=0;i<inorder.length;i++){
        if(inorder[i] == rootVal){
            rootIdx = i;
            break;
        }
    }
    
    int[] inorderleft = Arrays.copyOfRange(inorder,0,rootIdx);
    int[] inorderright = Arrays.copyOfRange(inorder,rootIdx+1,inorder.length);
    int[] postorderleft = Arrays.copyOfRange(postorder,0,rootIdx);
    int[] postorderright = Arrays.copyOfRange(postorder,rootIdx,postorder.length-1);
    
    root.left = buildTree(inorderleft,postorderleft);
    root.right = buildTree(inorderright,postorderright);
    
    return root;
}
