//Time Complexity: O(n2)
//Space Complexity: O(n2)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || postorder.length==0)
            return null;
        int rootidx=-1;
        int rootVal=postorder[postorder.length-1];
        TreeNode root=new TreeNode(rootVal);
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i])
                rootidx = i;
        }
        int [] inorderleft=Arrays.copyOfRange(inorder,0,rootidx);
        int [] inorderRight=Arrays.copyOfRange(inorder,rootidx+1,inorder.length);
        int[] postorderleft = Arrays.copyOfRange(postorder, 0, rootidx);
        int[] postorderright = Arrays.copyOfRange(postorder, rootidx, postorder.length - 1);
        root.left=buildTree(inorderleft,postorderleft);
        root.right=buildTree(inorderRight,postorderright);
        return root;
    }
}
