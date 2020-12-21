// Time Complexity :O(N)
// Space Complexity :O(N)
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
    HashMap<Integer, Integer> map;
    //pointer for postorder
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0){
            return null;
        }
        map = new HashMap<>();
        //add the values of inorder in map
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        idx = postorder.length - 1;
        return helper(postorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] postorder, int start, int end){
        //terminating condition
        if(start>end){
            return null;
        }
        //root value
        int rootVal = postorder[idx];
        idx--;
        int rootIdx = map.get(rootVal);
        //build tree one node at a time
        TreeNode root = new TreeNode(rootVal);
        //the right part
        root.right = helper(postorder, rootIdx + 1, end);
        //the left part 
        root.left = helper(postorder, start, rootIdx - 1);
        return root;
    }
}