//Time = O(n)
//Space = O(n) 

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
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        
        //In Postorder, last element is the root of the binary tree.
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        // Find the root in inorder
        int inRootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inRootIndex = i;
                break;
            }
        }
        
        // Numbers of nodes in left subtree
        int leftTreeSize = inRootIndex - inStart;
        
        // Building the left and right subtrees recursively 
        root.left = buildTree(inorder, inStart, inRootIndex - 1, postorder, postStart, postStart + leftTreeSize - 1);
        root.right = buildTree(inorder, inRootIndex + 1, inEnd, postorder, postStart + leftTreeSize, postEnd - 1);
        
        return root;
    }
}
