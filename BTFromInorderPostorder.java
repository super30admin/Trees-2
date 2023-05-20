// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

/*
 * Approach:
 * In order to construct the tree, we use the inorder array to obtain
 * the left and right subtree values, and the postorder array to obtain
 * the root of those subtrees.
 * We use a HashMap to store the indices of the inorder array in order to
 * optimize the lookup time in inorder array (when we search for the root
 * index).
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
import java.util.*;
class Solution {
    HashMap<Integer, Integer> m;
    int index; // always tracks root node of subtrees in postorder array

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0 ||
        inorder == null || inorder.length == 0) {
            return null;
        }

        // create a HashMap to optimize lookup of root node in inorder traversal array
        m = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            m.put(inorder[i], i);
        }

        // need to track root of subtrees in postorder array
        index = postorder.length - 1;

        // then use postorder to construct tree by keeping
        // pointers for start and end of each subtree.
        // initially the subtree is the entire tree, so start and end
        // are len-1 and 0 (reverse of preorder)
        return helper(postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        if(start > end) {
            return null;
        }

        int rootVal = postorder[index];
        index--;
        TreeNode root = new TreeNode(rootVal);
        
        // fetch from inorder array so that left and right subtrees can
        // be created from a split inorder array
        int rootIndex = m.get(rootVal);

        // do right first since it's postorder
        root.right = helper(postorder, rootIndex + 1, end);
        root.left = helper(postorder, start, rootIndex - 1);

        return root;
    }
}