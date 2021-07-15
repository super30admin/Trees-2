//Method 1:Bruteforce approach
// Time Complexity :O(N*N)
// Space Complexity :O(N*N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

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
//Tc:O(N*N)
//SC:O(N*N)
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null||postorder.length==0) return null;
        int in_indx=0,m=postorder.length-1;
        TreeNode root=new TreeNode(postorder[m]);

        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==postorder[m]) {
                in_indx=i;
                break;
            }
        }
        int[] post_left=Arrays.copyOfRange(postorder,0,in_indx);
        int[] post_right=Arrays.copyOfRange(postorder,in_indx,postorder.length-1);
        int [] in_left=Arrays.copyOfRange(inorder,0,in_indx);
        int[]  in_right=Arrays.copyOfRange(inorder,in_indx+1,inorder.length);
        root.left=buildTree(in_left,post_left);
        root.right=buildTree(in_right,post_right);
        return root;

    }
}