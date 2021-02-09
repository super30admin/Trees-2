// Time Complexity : O(N)
// Space Complexity : O(max(depth))
// Did this code successfully run on Leetcode : Y
// Any problem you faced while coding this :
Preorder iteration from end of int[] postorder to find root/children in int[] inorder

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    public TreeNode helper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd){
        if(inorderStart>inorderEnd || postorderStart>postorderEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postorderEnd]);
        int index = map.get(postorder[postorderEnd]);
        int leftTreeSize = index - inorderStart;

        root.left = helper(inorder,inorderStart,index-1,postorder,postorderStart,postorderStart+leftTreeSize-1);
        root.right = helper(inorder, index+1,inorderEnd, postorder,postorderStart+leftTreeSize,postorderEnd-1);

        return root;
    }
}