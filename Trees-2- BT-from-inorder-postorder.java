// Time Complexity : O(n ^ 2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        
        //base case
        if(postorder.length==0) return null;
        
        //Getting root from postorder array
        
        TreeNode root =  new TreeNode(postorder[postorder.length-1]);
        
        //Find index of root in inorder array
        
        int index = 0;
        
        
         for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val){
                index=i;
                break;
            }
        }
        
        //Splitting into sub-arrays
        
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder,index+1, inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder,0,index);
        int[] postRight = Arrays.copyOfRange(postorder,index,postorder.length-1);
        
        root.left = buildTree(inLeft,postLeft); //Left tree
        root.right = buildTree(inRight,postRight); //right tree
        
        return root;
        
        
    }
}