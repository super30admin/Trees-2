/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public TreeNode BuildTree(int[] inorder, int[] postorder) {
        if(inorder.Length == 0) return null;
        var rootVal = postorder[postorder.Length -1];
        var rootIdx = -1;
        var root = new TreeNode(rootVal);
        for(int i = 0; i< inorder.Length; i++)
        { 
            if(inorder[i] == rootVal)
            {
                rootIdx = i;
                break;
            }
        }           
        
        int[] inleft = new int[rootIdx];
        Array.Copy(inorder, 0, inleft, 0, rootIdx);
        int[] inright = new int[inorder.Length - (rootIdx +1)];
        Array.Copy(inorder, rootIdx + 1, inright, 0, inorder.Length - (rootIdx +1));
        int[] postright = new int[inright.Length];
        Array.Copy(postorder, postorder.Length -1 - inright.Length, postright, 0, inright.Length);
        int[] postleft = new int[postorder.Length - postright.Length - 1];
        Array.Copy(postorder, 0, postleft, 0, postorder.Length - postright.Length - 1);
        
        root.left = BuildTree(inleft, postleft);
        root.right = BuildTree(inright, postright);

        return root;        
    }
}
