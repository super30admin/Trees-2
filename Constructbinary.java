// Time Complexity :O(N) where n is the number of nodes 
// Space Complexity :O(N) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach:
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
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         if(postorder==null || postorder.length==0)
            return null;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < inorder.length ; i++){
            map.put(inorder[i],i);
        }
        index=postorder.length-1;
        return helper(postorder,map,0,inorder.length-1);
    }
    public TreeNode helper(int[] postorder, HashMap<Integer, Integer> map, int start, int end){
        if(start>end)
            return null;
        int value = postorder[index];
        TreeNode root = new TreeNode(value);
        int rootIndex = map.get(value);
        index--;
        root.right = helper(postorder,map,rootIndex+1,end);        
        root.left = helper(postorder,map,start,rootIndex-1);
        return root;
    }
}