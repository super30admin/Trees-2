// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    public HashMap<Integer,Integer> m = new HashMap<>();
    public int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {    
        for(int i=0;i<inorder.length;i++){
            m.put(inorder[i],i);
        }
        return helper(0,inorder.length-1,postorder);
    }
    public TreeNode helper(int iStart,int iEnd,int[] postorder){ 
        if(iEnd<iStart){
            return null;
        }
        int rootVal = postorder[postorder.length-1-idx];
        TreeNode n = new TreeNode(rootVal);
        idx++;
        int rootIdx = m.get(rootVal);
        n.right=helper(rootIdx+1,iEnd,postorder);
        n.left=helper(iStart,rootIdx-1,postorder);
        return n;
    }
}