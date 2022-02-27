// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

int inorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndex = 0;
        return buildTree1(preorder, inorder, 0);
    }


    public TreeNode buildTree1(int[] preorder, int[] inorder, int preorderIndex ) {

        if(preorderIndex == preorder.length ) return null;


        TreeNode curr = new TreeNode(preorder[preorderIndex]);

        if(inorderIndex < inorder.length && preorder[preorderIndex] == inorder[inorderIndex] ){
            inorderIndex++;
            return curr;
        }


        curr.left = buildTree1(preorder, inorder, preorderIndex+1);

        while(inorderIndex < inorder.length && preorder[preorderIndex] == inorder[inorderIndex] ){
            inorderIndex++;
        }

        curr.right = buildTree1(preorder, inorder, preorderIndex+1);

        return curr;


    }
