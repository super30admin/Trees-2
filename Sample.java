//Binary tree from inorder and postorder
// Time Complexity :0(n^2)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0 || postorder.length==0)
            return null;
        TreeNode root= new TreeNode(postorder[postorder.length-1]);
        int index=-1;
        for(int x=0;x<inorder.length;x++)
        {
            if(inorder[x]==root.val){
                index=x;
                break;
            }
        }
        int leftsize=index;
        int rightsize=inorder.length-1-index;
        int[] inleft=Arrays.copyOfRange(inorder,0,index);
        int[] inright=Arrays.copyOfRange(inorder,index+1,inorder.length);
        int[] postleft=Arrays.copyOfRange(postorder,0,leftsize);
        int[] postright=Arrays.copyOfRange(postorder,leftsize,postorder.length-1);
        
        
        root.left=buildTree(inleft,postleft);
        root.right=buildTree(inright,postright);
        
        return root;
    }

}
//sum root to leaf numbers
// Time Complexity :0(n)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
class Solution {
    public int sumNumbers(TreeNode root) {
        
        
        recurr(root,0);
        return output;
       
        }
    private int output=0;
     private void recurr(TreeNode root, int prev){
            if(root==null)
            {
                return;
            }
            int curr= prev*10+root.val;
            if(root.left==null && root.right==null)
            {
            output +=curr;
                return;
            }
            recurr(root.left,curr);
            recurr(root.right,curr);
    }
}
