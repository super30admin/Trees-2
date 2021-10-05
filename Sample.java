// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
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

    //Using hashmap to reduce the time 
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(postorder == null || postorder.length == 0){
            return null;
        }
        idx = postorder.length - 1;
        map = new HashMap<>();
        for(int i = 0; i< inorder.length; i++){
            map.put(inorder[i] , i);
        }
        return helper(postorder, 0, postorder.length-1);
        
    }
    private TreeNode helper(int[] postorder, int start, int end){
        if (start > end ){
            return null;
        }
        System.out.println(idx);
        int rootVal = postorder[idx];
        
        idx --;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.right = helper(postorder, rootIdx +1, end);
        root.left = helper(postorder, start, rootIdx -1);
        return root;
        
        
    }
}