public class BinaryTreeFromInorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, inorder.length-1, 0, postorder.length-1, inorder, postorder);
    }
    public TreeNode helper(int is, int ie, int ps, int pe, int[] inorder, int[] postorder){
        if(is > ie || ps > pe){
            return null;
        }
        int rootVal = postorder[pe];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        for(int i = is; i <= ie; i++){
            if(inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        int leftSize = rootIndex - is;
        int rightSize = ie - rootIndex;
        root.left = helper(is, rootIndex-1, ps, ps+leftSize-1, inorder, postorder);
        root.right = helper(rootIndex+1, ie, ps+leftSize, pe-1, inorder, postorder);
        return root;
    }
}
