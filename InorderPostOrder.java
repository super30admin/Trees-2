// Time Complexity : O(n)   // n is number of nodes 
// Space Complexity : O(n) // n is number of nodes
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
    HashMap<Integer,Integer> map = new HashMap<>();
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        postIndex = postorder.length-1;
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return helper(postorder,0,inorder.length-1);
    }
    
    private TreeNode helper(int [] postorder, int start, int end)
    {
       if(start>end) return null;
        
        int rootVal = postorder[postIndex];
        postIndex--;
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);
        root.right = helper(postorder,index+1,end);
        root.left = helper(postorder, start,index-1);
        return root;
    }
}