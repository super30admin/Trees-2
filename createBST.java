
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
 * TC --> O(n)
 * SC --> O(n)
 */
class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }//for

        TreeNode root = createTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;

    }//method

    public TreeNode createTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
        if (postStart > postEnd || postEnd < 0 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        //check for root right
        int idx = map.get(postorder[postEnd]);
        int numsRight = inEnd - idx;
        int numsLeft = idx - inStart;
        root.right = createTree(postorder, postEnd - numsRight, postEnd - 1, inorder, idx + 1, inEnd, map);

        //check for left 
        root.left = createTree(postorder, postEnd - numsRight - numsLeft, postEnd - numsRight - 1, inorder, inStart, idx - 1, map);

        return root;

    }//method

}//class
