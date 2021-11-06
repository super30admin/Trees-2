// 106 Construct Binary Tree from inorder and postorder Traversal 
// solved on leetcode
// Time complexity - O(n^2)
// Space complexity - O(n^2)

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
        if(inorder.length==0 || postorder.length==0){
            return null;
        }
        TreeNode curr = new TreeNode(postorder[postorder.length-1]);
        int inorderIndex=0;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==curr.val){
                inorderIndex=i;
            }
        }
        
        int [] rightinorder=Arrays.copyOfRange(inorder,inorderIndex+1,inorder.length);
        int [] rightpostorder=Arrays.copyOfRange(postorder,inorderIndex,postorder.length-1);
        
        int [] leftinorder=Arrays.copyOfRange(inorder,0,inorderIndex);
        int [] leftpostorder=Arrays.copyOfRange(postorder,0,inorderIndex);
        
        curr.right = buildTree(rightinorder,rightpostorder);
        curr.left = buildTree(leftinorder,leftpostorder);
        
        return curr;
    }
}