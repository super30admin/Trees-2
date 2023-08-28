// TC = O(n)
// SC = O(n)
//Here we are finding root in preorder the look for root in inorder. and the find the length of inleft, inRight
//preLeft and preRight.
class ContructBinaryTree{
       public TreeNode buildTree(int[] preorder, int[] inorder) {
                if(preorder.length == 0) return null;
                int rootVal = preorder[0];
                TreeNode root = new TreeNode(rootVal);
                int index = -1;
                for(int i=0; i<inorder.length; i++){
                    if(inorder[i] == rootVal){
                        index = i;
                        break;
                    }
                }

                int[] intLeft = Arrays.copyOfRange(inorder, 0 , index);
                int[] intRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
                int[] preLeft = Arrays.copyOfRange(preorder, 1, intLeft.length+1);
                int[] preRight = Arrays.copyOfRange(preorder, intLeft.length+1, preorder.length);

                root.left = buildTree(preLeft,intLeft);
                root.right = buildTree(preRight,intRight);
                return root;   
    }
}