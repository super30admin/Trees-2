//Time Complexity  : O(n)
//Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// It is similar to inorder and pre order problem , where in pre order we are traversing the root from first element of array. 
// But here we are traversing it from end and we should not include the breakIndex value subleft post and subRight Post



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
        // base case
        if(postorder.length == 0) return null;
        
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        
        if(postorder.length == 1) return root;
        
        int breakIndex=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i] == root.val){
                breakIndex = i;
                break;
            }
        }
        //System.out.println("After:"+breakIndex);
        //Identifying the sub left in order and sub right in order arrays
        int[] subLeftIn    = Arrays.copyOfRange(inorder,0,breakIndex);
        int[] subRightIn   = Arrays.copyOfRange(inorder,breakIndex+1,inorder.length);
            
        int[] subLeftPost  = Arrays.copyOfRange(postorder,0,breakIndex);
        int[] subRightPost = Arrays.copyOfRange(postorder,breakIndex,postorder.length-1);
        
        //System.out.println(Arrays.toString(subLeftIn) + Arrays.toString(subLeftPost));
        root.left  = buildTree(subLeftIn, subLeftPost);
        //System.out.println(Arrays.toString(subRightIn) + Arrays.toString(subRightPost));
        root.right = buildTree(subRightIn, subRightPost);  
        
        return root;
        
    }
}
