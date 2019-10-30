//Time complexity -O[N]
//Spce complexity- o[N]
// Didnt run on leetcode got arrays out of bounds error

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //edge case
        if(postorder.length==0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int index = -1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }
        int [] postLeft = Arrays.copyOfRange(postorder,0,index);
        int [] postRight = Arrays.copyOfRange(postorder,index,postorder.length-1);
        int [] inLeft = Arrays.copyOfRange(inorder,0,index);
        int [] inRight = Arrays.copyOfRange(inorder,index+1,inorder.length);
        root.left = buildTree(postLeft,inLeft);
        root.right = buildTree(postRight,inRight);
        return root;
        
    }
}