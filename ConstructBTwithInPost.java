// Time Complexity : O(n) n nodes in the tree
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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

        map = new HashMap();

        for(int i=0; i<inorder.length; i++)
            map.put(inorder[i], i);

        return recursion(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);

    }

    public TreeNode recursion(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd)
    {
        //base case

        if(inStart > inEnd || postStart > postEnd)
            return null;

        //logic

        int rootVal = postorder[postEnd];

        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = map.get(rootVal);

        TreeNode left = recursion(inorder, inStart, inorderIndex-1, postorder, postStart, postEnd - (inEnd - inorderIndex) -1);

        TreeNode right = recursion(inorder, inorderIndex+1, inEnd, postorder, postEnd - (inEnd - inorderIndex), postEnd-1);

        root.left = left;

        root.right = right;

        return root;
    }
}
