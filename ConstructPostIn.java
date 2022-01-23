// Time Complexity O(N)
// Space Complexity O(1)
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0) return null;
        int preMain = postorder[postorder.length-1];
        TreeNode root = new TreeNode(preMain);
        int indexMain = -1;
        //Find main root in Inorder 
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == preMain){
                indexMain = i;
                break;
            }
        }        
        int[] inLeft = Arrays.copyOfRange(inorder, 0, indexMain);
        int[] inRight = Arrays.copyOfRange(inorder, indexMain+1, inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, indexMain);
        int[] postRight = Arrays.copyOfRange(postorder,indexMain, postorder.length-1);
        root.left = buildTree(inLeft,postLeft);
        root.right = buildTree(inRight, postRight);
        return root; 
    }
}