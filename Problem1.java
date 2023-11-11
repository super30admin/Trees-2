//Time Complexity  : O(n^2)
//Space Complexity : O(n^2)

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length ==0) return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootindex=-1;
        for(int i=0; i< inorder.length; i++){
            if(inorder[i]==rootVal){
                rootindex = i;
            }
        }
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootindex);
        int[] inRight = Arrays.copyOfRange(inorder, rootindex +1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1,1+inLeft.length);
        int[] preRight = Arrays.copyOfRange(preorder, 1+inLeft.length, preorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}
