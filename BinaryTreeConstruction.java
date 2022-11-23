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
 //Time complexity is O(N)
 //Space complexity is O(N)
class Solution {
    int postorderIndex;
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length-1);
    }
    public TreeNode helper(int[] inorder, int[] postorder, int left, int right){
        if(left>right){
            return null;
        }
        int temp =postorder[postorderIndex];
        postorderIndex=postorderIndex-1;
        TreeNode root = new TreeNode(temp);
        root.right = helper(inorder, postorder, hm.get(temp)+1, right);
        root.left= helper(inorder, postorder, left, hm.get(temp)-1);
        return root;
    }
}