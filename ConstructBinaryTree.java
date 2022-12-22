// Time Complexity : O(n)
// Space Complexity :O(n^2)

/*
 * here we get a root value from the postorder and search for that in the inorder
 * the left to it is the left subtree and right side is the right subtree. then 
 * we run the same for the left and right subtree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //base
        if(inorder.length == 0) return null;

        //logic
        int rootVal = postorder[postorder.length-1];
        TreeNode root = new TreeNode(rootVal);
        System.out.println(root.val);
        int idx = -1;
        for (int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                idx = i;
                break;
            }
        }
        System.out.println(idx);
        int[] inleft = Arrays.copyOfRange(inorder, 0, idx);
        int[] inright = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        int[] postleft = Arrays.copyOfRange(postorder, 0, inleft.length);
        int[] postright  = Arrays.copyOfRange(postorder, inleft.length, inorder.length-1);
        root.left = buildTree(inleft, postleft);
        root.right = buildTree(inright, postright);

        return root;
    }
}