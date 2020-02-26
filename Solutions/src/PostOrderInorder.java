// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :No
// Any problem you faced while coding this : issue woth pointers
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class PostOrderInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        int rootval = postorder[postorder.length-1];
        int rootindex = 0;

        // Find root
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == rootval){
                rootindex = i;
            }
            break;
        }
        TreeNode root = new TreeNode(rootval);
        int[] inorderleft = Arrays.copyOfRange(inorder, 0, rootindex);
        int[] inorderright = Arrays.copyOfRange(inorder,rootindex+1, inorder.length);
        int[] postorderleft = Arrays.copyOfRange(postorder, 0,rootindex);
        int[] postorderright = Arrays.copyOfRange(postorder,rootindex, postorder.length -1);
        root.left=buildTree(inorderleft, postorderleft);
        root.right = buildTree(inorderright,postorderright);
        return root;
    }
}