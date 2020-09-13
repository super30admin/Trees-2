// Time Complexity : O(n*n)
// Space Complexity : O(n*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Similar to the solution of previous problem build tree by using Preorder and Inorder
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0){
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int index = 0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == root.val){
                index = i;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder,0,index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1,inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder, 0,index);
        int[] postRight = Arrays.copyOfRange(postorder, index,postorder.length-1);

        root.left = buildTree(inLeft,postLeft);
        root.right = buildTree(inRight,postRight);
        return root;
    }
}

