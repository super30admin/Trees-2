//TC O(N^2)
//SC O(N^2)

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
		
        if(postorder.length == 0) return null;
        
        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = 0;
		
        //Find the node element from inorder array
        for(int i=0;i<inorder.length;i++) {
            if(inorder[i] == root.val) {
                rootIdx = i;
            }
        }

        int[] preLeft = Arrays.copyOfRange(postorder, 0, rootIdx);
        int[] prRight = Arrays.copyOfRange(postorder, rootIdx, postorder.length-1);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);

        root.left = buildTree(inLeft, preLeft);
        root.right = buildTree(inRight, prRight);
        return root;
    } 
}