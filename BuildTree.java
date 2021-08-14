/* Time Complexity :  O(n) where n is the length of the array/no of nodes
   Space Complexity :  O(n) 
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
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
    HashMap<Integer,Integer> hm;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null ||inorder.length==0)
        {
            return null;
        }
        idx=postorder.length-1;
        hm = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            hm.put(inorder[i],i);
        return helper(postorder,0,postorder.length-1);
    }
    private TreeNode helper(int[] postorder, int start, int end){
        if(start>end)
            return null;
        TreeNode root = new TreeNode(postorder[idx]);
        idx--;
        int index = hm.get(root.val);
        root.right=helper(postorder,index+1,end);
        root.left=helper(postorder,start,index-1);
        return root;
    }
}